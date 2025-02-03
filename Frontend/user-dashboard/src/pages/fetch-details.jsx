import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

function ShowPersonalDetails() {
    const [userData, setUserData] = useState(null);
    const location = useLocation();
    const username = location.state?.username;

    useEffect(() => {
        const fetchData = async () => {
            try {
                if (!username) return;
                const response = await fetch(`http://localhost:8080/user-details/${username}`);
                if (!response.ok) throw new Error('Failed to fetch personal details');
                const data = await response.json();
                setUserData(data);
            } catch (error) {
                console.error('Error fetching personal details:', error);
            }
        };

        fetchData();
    }, [username]);

    return (
        <div>
            <h1>Personal Details</h1>
            {userData ? (
                <div>
                    <p>Username: {userData.username}</p>
                    <p>Phone: {userData.phone}</p>
                    <p>Age: {userData.age}</p>
                    <p>Address: {userData.address}</p>
                </div>
            ) : (
                <p>No personal details found.</p>
            )}
        </div>
    );
}


export default ShowPersonalDetails;