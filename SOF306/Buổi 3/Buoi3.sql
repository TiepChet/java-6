CREATE DATABASE demo;

USE demo;

CREATE TABLE may_tinh(
	ma UNIQUEIDENTIFIER PRIMARY KEY DEFAULT NEWID(),
	ten nvarchar(100),
	gia float,
	bo_nho nvarchar(100),
	mau_sac nvarchar(100),
	hang nvarchar(100),
	mieu_ta nvarchar(100)
)