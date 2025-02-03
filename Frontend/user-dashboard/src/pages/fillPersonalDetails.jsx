import React, { useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';

function FillPersonalDetails() {
    const navigate = useNavigate();
    const location = useLocation();
    const email = location.state?.email || ''; // Retrieve email from state

    const [username, setUsername] = useState('');
    const [phone, setPhone] = useState('');
    const [age, setAge] = useState('');
    const [address, setAddress] = useState('');
    const [message, setMessage] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [loading, setLoading] = useState(false);

    const handleFormSubmit = async (e) => {
        e.preventDefault();
        if (!username || !phone || !age || !address) {
            setErrorMessage('All fields are required.');
            return;
        }

        setLoading(true);
        try {
            // console.log(email);
            const response = await fetch(`http://localhost:8080/user-details/${email}`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ username, phone, age: parseInt(age), address }),
            });

            if (!response.ok) throw new Error('Failed to submit personal details');
            setMessage('Personal details submitted successfully!');
            console.log("*************"+response.data)
            navigate('/dashboard', { state: { email } }); // Redirect to dashboard with email
        } catch (error) {
            console.error('Error submitting personal details:', error);
            setErrorMessage('Error submitting personal details. Please try again later.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <h1>Fill Personal Details</h1>
            {message && <p>{message}</p>}
            {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
            <form onSubmit={handleFormSubmit}>
                <div>
                    <label>Username:</label>
                    <input
                        type="text"
                        value={username}
                        onChange={(e) => setUsername(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Phone:</label>
                    <input
                        type="text"
                        value={phone}
                        onChange={(e) => setPhone(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Age:</label>
                    <input
                        type="number"
                        value={age}
                        onChange={(e) => setAge(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Address:</label>
                    <input
                        type="text"
                        value={address}
                        onChange={(e) => setAddress(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" disabled={loading}>
                    {loading ? 'Submitting...' : 'Submit Personal Details'}
                </button>
            </form>
        </div>
    );
}

export default FillPersonalDetails;