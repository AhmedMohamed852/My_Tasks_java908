<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.hospital.model.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hospital Details Report</title>

<style>
/* ==== GLOBAL STYLES ==== */
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #eef3f7;
    padding: 30px;
    margin: 0;
}

h1 {
    text-align: center;
    color: #007bff;
    margin-bottom: 10px;
}

.actions {
    text-align: center;
    margin-bottom: 20px;
}

.btn {
    display: inline-block;
    padding: 8px 16px;
    margin: 5px;
    border-radius: 6px;
    font-size: 14px;
    font-weight: 600;
    text-decoration: none;
    transition: all 0.2s ease;
    cursor: pointer;
}

.btn-update {
    background-color: #007bff;
    color: white;
    border: 1px solid #007bff;
}

.btn-update:hover {
    background-color: #0056b3;
}

/* ==== TABLE STYLING ==== */
table {
    width: 95%;
    max-width: 1200px;
    margin: 0 auto;
    border-collapse: collapse;
    background-color: white;
    box-shadow: 0 6px 15px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    overflow: hidden;
}

thead {
    background-color: #007bff;
    color: white;
    text-transform: uppercase;
    letter-spacing: 0.5px;
}

th, td {
    padding: 12px 15px;
    border-bottom: 1px solid #ddd;
    text-align: left;
}

tbody tr:nth-child(even) {
    background-color: #f9f9f9;
}

tbody tr:hover {
    background-color: #e9ecef;
}

/* ==== STATUS COLORS ==== */
.status-completed { color: #28a745; font-weight: bold; }
.status-scheduled { color: #007bff; font-weight: bold; }
.status-cancelled { color: #dc3545; font-weight: bold; }

.no-data {
    text-align: center;
    padding: 20px;
    font-weight: bold;
    color: #dc3545;
}
</style>
</head>
<body>

<h1>Hospital Details Report</h1>

<!-- === ACTION BUTTONS ABOVE TABLE === -->
<div class="actions">
    <a href="/hospital_management/HospitalController?action=getItem" class="btn btn-update">➕ Add Doctor</a>
    <a href="/hospital_management/HospitalController?action=addPatient" class="btn btn-update">➕ Add Patient</a>
</div>

<%
    List<Hospital> details = (List<Hospital>) request.getAttribute("details");
%>

<table>
    <thead>
        <tr>
            <th>Doctor ID</th>
            <th>First Name (D)</th>
            <th>Last Name (D)</th>
            <th>Specialization</th>
            <th>Patient ID</th>
            <th>First Name (P)</th>
            <th>Last Name (P)</th>
            <th>Phone (P)</th>
            <th>Status (P)</th>
        </tr>
    </thead>
    <tbody>
        <% if (details != null && !details.isEmpty()) {
            for (Hospital detail : details) { %>
                <tr>
                    <td><%= detail.getDOCTOR_ID() %></td>
                    <td><%= detail.getFIRST_NAME_D() %></td>
                    <td><%= detail.getLAST_NAME_D() %></td>
                    <td><%= detail.getSPECIALIZATION() %></td>
                    <td><%= detail.getPATIENT_ID() %></td>
                    <td><%= detail.getFIRST_NAME_P() %></td>
                    <td><%= detail.getLAST_NAME_P() %></td>
                    <td><%= detail.getPHONE_P() %></td>
                    <td><%= detail.getStatus() %></td>
                </tr>
        <%  } } else { %>
                <tr>
                    <td colspan="9" class="no-data">
                        ⚠ No Doctor or Patient details found in the database.
                    </td>
                </tr>
        <% } %>
    </tbody>
</table>

</body>
</html>
