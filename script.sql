USE [master]
GO
/****** Object:  Database [J3.L.P0004]    Script Date: 09/01/2023 17:42:52 ******/
CREATE DATABASE [J3.L.P0004]
go
USE [J3.L.P0004]
GO
/****** Object:  Table [dbo].[User]    Script Date: 09/01/2023 17:42:52 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[Email] [varchar](255) NOT NULL,
	[Name] [nvarchar](255) NULL,
	[Password] [varchar](255) NULL,
	[Role] [varchar](255) NULL,
	[Status] [varchar](255) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[Email] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
USE [master]
GO
ALTER DATABASE [J3.L.P0004] SET  READ_WRITE 
GO
