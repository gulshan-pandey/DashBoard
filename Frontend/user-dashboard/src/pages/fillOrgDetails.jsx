import React, { useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';

function FillOrganizationDetails() {
    const navigate = useNavigate();
    const location = useLocation();
    const username = location.state?.username || '';
    const email = location.state?.email || '';
    
    const [managerName, setManagerName] = useState('');
    const [organization, setOrganization] = useState('');
    const [companyAddress, setCompanyAddress] = useState('');
    const [message, setMessage] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [loading, setLoading] = useState(false);

    const handleFormSubmit = async (e) => {
        e.preventDefault();
        if (!username || !managerName || !organization || !companyAddress) {
            setErrorMessage('All fields are required.');
            return;
        }

        setLoading(true);
        try {
            const response = await fetch(`http://localhost:8080/org-details/${username}`, {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ managerName, organization, companyAddress }),
            });

            if (!response.ok) throw new Error('Failed to submit organization details');
            setMessage('Organization details submitted successfully!');
            navigate('/dashboard', { state: { email } });
        } catch (error) {
            console.error('Error submitting organization details:', error);
            setErrorMessage('Error submitting organization details. Please try again later.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <h1>Fill Organization Details</h1>
            {message && <p>{message}</p>}
            {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
            <form onSubmit={handleFormSubmit}>
                <div>
                    <label>Manager Name:</label>
                    <input
                        type="text"
                        value={managerName}
                        onChange={(e) => setManagerName(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Organization:</label>
                    <input
                        type="text"
                        value={organization}
                        onChange={(e) => setOrganization(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Company Address:</label>
                    <input
                        type="text"
                        value={companyAddress}
                        onChange={(e) => setCompanyAddress(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" disabled={loading}>
                    {loading ? 'Submitting...' : 'Submit Organization Details'}
                </button>
            </form>
        </div>
    );
}


export default FillOrganizationDetails;