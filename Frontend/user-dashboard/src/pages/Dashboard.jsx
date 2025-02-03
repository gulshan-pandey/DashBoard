import React, { useEffect, useState } from 'react';
import { useNavigate, useLocation } from 'react-router-dom';

function Dashboard() {
    const navigate = useNavigate();
    const location = useLocation();
    const email = location.state?.email || '';
    const [userData, setUserData] = useState(null);
    const [orgData, setOrgData] = useState(null);

    useEffect(() => {
        const fetchData = async () => {
            try {
                if (!email) return;

                const userResponse = await fetch(`http://localhost:8080/user-details/${email}`);
                if (!userResponse.ok) throw new Error('Failed to fetch user details');
                const userData = await userResponse.json();
                console.log("userData", userData)
                setUserData(userData);

                if (userData.username) {
                    const orgResponse = await fetch(`http://localhost:8080/org-details/${userData.username}`);
                    if (!orgResponse.ok) throw new Error('Failed to fetch organization details');
                    const orgData = await orgResponse.json();
                    setOrgData(orgData);
                }
            } catch (error) {
                console.error('Error fetching data:', error);
            }
        };

        fetchData();
    }, [email]);

    return (
        <div>
            <h1>Dashboard</h1>
            <p>Welcome, {email}</p>
            <div style={{ display: 'flex', gap: '10px' }}>
                <button
                    onClick={() => navigate('/fill-personal-details', { state: { email } })}
                    disabled={Boolean(userData)}
                >
                    Fill Personal Details
                </button>
                <button
                    onClick={() => navigate('/fill-organization-details', { 
                        state: { email, username: userData?.username } 
                    })}
                    disabled={!!orgData || !userData}
                >
                    Fill Organization Details
                </button>
                <button 
                    onClick={() => navigate('/show-personal-details', { 
                        state: { username: email } 
                    })}
                >
                    Show Personal Details
                </button>
                <button 
                    onClick={() => navigate('/show-organization-details', { 
                        state: { username: userData?.username } 
                    })}
                >
                    Show Organization Details
                </button>
            </div>
        </div>
    );
}


export default Dashboard;