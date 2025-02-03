import React, { useEffect, useState } from 'react';
import { useLocation } from 'react-router-dom';

function ShowOrganizationDetails() {
    const [orgData, setOrgData] = useState(null);
    const location = useLocation();
    const username = location.state?.username;

    useEffect(() => {
        const fetchData = async () => {
            try {
                if (!username) return;
                const response = await fetch(`http://localhost:8080/org-details/${username}`);
                if (!response.ok) throw new Error('Failed to fetch organization details');
                const data = await response.json();
                setOrgData(data);
            } catch (error) {
                console.error('Error fetching organization details:', error);
            }
        };

        fetchData();
    }, [username]);

    return (
        <div>
            <h1>Organization Details</h1>
            {orgData ? (
                <div>
                    <p>Manager: {orgData.managerName}</p>
                    <p>Organization: {orgData.organization}</p>
                    <p>Address: {orgData.companyAddress}</p>
                </div>
            ) : (
                <p>No organization details found.</p>
            )}
        </div>
    );
}
export default ShowOrganizationDetails;