import React, { useState } from 'react';
import { useNavigate, Link } from 'react-router-dom';

function Login() {
    const navigate = useNavigate();
    const [userId, setUserId] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const [loading, setLoading] = useState(false);

    const handleLogin = async (e) => {
        e.preventDefault();
        setLoading(true);
        try {
            const response = await fetch('http://localhost:8080/login', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify({ userId, password }),
            });

            const data = await response.json();
            if (response.ok && data) {
                navigate('/dashboard', { state: { email: userId } }); 
            } else {
                setErrorMessage('Bad credentials or user does not exist');
            }
        } catch (error) {
            console.error('Error logging in:', error);
            setErrorMessage('Something went wrong. Please try again later.');
        } finally {
            setLoading(false);
        }
    };

    return (
        <div>
            <h1>Login</h1>
            <form onSubmit={handleLogin}>
                <div>
                    <label>Email:</label>
                    <input
                        type="email"
                        value={userId}
                        onChange={(e) => setUserId(e.target.value)}
                        required
                    />
                </div>
                <div>
                    <label>Password:</label>
                    <input
                        type="password"
                        value={password}
                        onChange={(e) => setPassword(e.target.value)}
                        required
                    />
                </div>
                <button type="submit" disabled={loading}>
                    {loading ? 'Logging in...' : 'Login'}
                </button>
            </form>
            {errorMessage && <p style={{ color: 'red' }}>{errorMessage}</p>}
            <p>
                Don't have an account? <Link to="/register">Register here</Link>
            </p>
        </div>
    );
}

export default Login;