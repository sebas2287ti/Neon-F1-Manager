<p align="center">
  <img src="sources/Image/readmi/BannerF1.png" alt="F1 Manager Banner" width="100%">
</p>

#  F1 Manager DataBase

### The Ultimate Starting Grid Log

## Introduction

This repository contains an interactive database application called “Formula 1 Manager Database,” designed to simulate the real-world management of data on teams and their drivers throughout the season. By decoupling the logic of the graphical interface from data access through a robust Data Access Object (DAO) architecture, this system bridges the gap between a native, highly responsive graphical user interface (GUI) and a high-performance serverless Neon PostgreSQL backend.

## Installation

Follow these steps to set up the development environment and run the application locally.

### Prerequisites

Before running the application, ensure you have the following installed and configured:

**Java Development Kit (JDK 17 or higher):** The project relies on modern Java features.
**Java Swing Library:** Included in the standard JDK for rendering the graphical user interface (GUI).
**Neon Serverless Postgres Instance:** An active cloud database instance on [Neon.tech](https://neon.tech/).

### Database Schema Setup

Connect to your Neon PostgreSQL instance and execute the following SQL script to create the definitive pilot registration table:

```sql
CREATE TABLE f1_pilots (
    id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
    año SMALLINT NOT NULL,
    equipo TEXT NOT NULL,
    nombre TEXT NOT NULL,
    n_piloto SMALLINT NOT NULL,
    pilotoprincipal BOOLEAN NOT NULL,
    ganarmundialpilotos BOOLEAN NOT NULL,
    posicioncampeonato SMALLINT NOT NULL,
    puntoscampeonato SMALLINT NOT NULL,
    victorias SMALLINT NOT NULL,
    poles SMALLINT NOT NULL,
    n_campeonato SMALLINT NOT NULL,
    totalcarreras SMALLINT NOT NULL
);