USE [master]
GO
/****** Object:  Database [J3.L.P0004]    Script Date: 10/01/2023 14:59:04 ******/
CREATE DATABASE [J3.L.P0004]
GO
USE [J3.L.P0004]
GO
/****** Object:  Table [dbo].[Article]    Script Date: 10/01/2023 14:59:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Article](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](255) NULL,
	[ShortDescription] [nvarchar](255) NULL,
	[Content] [nvarchar](255) NULL,
	[PostingDate] [datetime] NULL,
	[Status] [varchar](255) NULL,
 CONSTRAINT [PK__Article__3214EC072FCD100A] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Comment]    Script Date: 10/01/2023 14:59:05 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Comment](
	[Id] [int] IDENTITY(1,1) NOT NULL,
	[Description] [nvarchar](255) NOT NULL,
	[UserEmail] [varchar](255) NOT NULL,
	[ArticleId] [int] NOT NULL,
 CONSTRAINT [PK__Comment__3214EC076F6BC1AF] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 10/01/2023 14:59:05 ******/
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
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK__Comment__Article__5DCAEF64] FOREIGN KEY([ArticleId])
REFERENCES [dbo].[Article] ([Id])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK__Comment__Article__5DCAEF64]
GO
ALTER TABLE [dbo].[Comment]  WITH CHECK ADD  CONSTRAINT [FK__Comment__UserEma__5CD6CB2B] FOREIGN KEY([UserEmail])
REFERENCES [dbo].[User] ([Email])
GO
ALTER TABLE [dbo].[Comment] CHECK CONSTRAINT [FK__Comment__UserEma__5CD6CB2B]
GO
USE [master]
GO
ALTER DATABASE [J3.L.P0004] SET  READ_WRITE 
GO
