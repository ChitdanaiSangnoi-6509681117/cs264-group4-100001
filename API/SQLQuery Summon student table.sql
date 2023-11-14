USE SoftwareProject264;

CREATE TABLE student (
    userName NVARCHAR(255) PRIMARY KEY,
    statusid NVARCHAR(255),
    statusname NVARCHAR(255),
    prefixname NVARCHAR(255),
    displayname_th NVARCHAR(255),
    displayname_en NVARCHAR(255),
    email NVARCHAR(255),
    department NVARCHAR(255),
    faculty NVARCHAR(255)
);
