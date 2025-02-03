import React from 'react';
import { BrowserRouter, Routes, Route, Navigate } from 'react-router-dom';
import Login from './pages/Login.jsx';
import Register from './pages/Register.jsx';
import Dashboard from './pages/Dashboard.jsx';
import FillPersonalDetails from './pages/fillPersonalDetails.jsx';
import FillOrganizationDetails from './pages/fillOrgDetails.jsx';
import ShowPersonalDetails from './pages/fetch-details.jsx';
import ShowOrganizationDetails from './pages/ShowOrganizationDetails.jsx';

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/login" replace />} />
        <Route path="/login" element={<Login />} />
        <Route path="/register" element={<Register />} />
        <Route path="/dashboard" element={<Dashboard />} />
        <Route path="/fill-personal-details" element={<FillPersonalDetails />} />
        <Route path="/fill-organization-details" element={<FillOrganizationDetails />} />
        <Route path="/show-personal-details" element={<ShowPersonalDetails />} />
        <Route path="/show-organization-details" element={<ShowOrganizationDetails />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
