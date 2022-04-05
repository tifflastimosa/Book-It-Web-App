# CS_5200 Spring 2022 Final Project

## 1. Name of the project

**LetsBookIt**

## 2. Name of the team and names of the team members

Team Name: project-SP22-kabilaw-tlastimosa-moranandrew

Team Members: Kabila Williams, Tiffany Lastimosa, Andrew Moran

## 3. Brief description of the project

LetsBookIt is a tool that assists with providing a shared platform for different types of markets, fairs, conventions, or other types of event-based organizations to give vendors the usability to book their preferred stand spaces at events.

## 4. Description of the two user data models

The user data model **Market Staff** is a **User** that has a **Role** associated with the management of a **Market**.

The user data model **Vendor Staff** is a **User** that has a **Role** associated with the management of a **Vendor**.

## 5. Description of the three domain object data models

The domain object data model **Market** represents a market, fair, convention, or other organization (e.g. Emerald City Comic Convention) that puts on **Events** (e.g. Friday, Saturday, Sunday, etc.) at a specified frequency for **Vendors** to book **Stands**.

The domain object data model **Event** is a scheduled occurrence for a **Market** and consists of **Stands** for **Vendors** to book.

The domain object data model **Stand** represents a table or space at an **Event** for a **Vendor** to book for use.

The domain object data model **Vendor** represents an organization that provides or sells a service or good at a **Stand** that they have booked at an **Event**.

## 6. Description of the user to domain object relationship

**Market Staff** manage a **Market** and its associated **Events** and **Stands**.

**Vendor Staff** manage a **Vendor** and are responsible for booking the **Vendor** for **Stands** at **Events**.

## 7. Description of the domain object to domain object relationship

A **Market** holds anywhere from a single to multiple **Events**.

An **Event** consists of multiple **Stands**.

A **Stand** is not booked until a **Vendor** books it.

A **Vendor** can book **Stands** at multiple **Events**.

## 8. Description of the portable enumeration(s)

The **Role** enumeration consists of different roles that **Market Staff** can have in a **Market** and that **Vendor Staff** can have in a **Vendor**. These roles are **Manager**, **Organizer**, or **Associate**.

The **Frequency** enumeration consists of different frequency rates at which a **Market** has **Events**. These frequencies are **One-Time**, **Weekly**, **Monthly**, **Quarterly**, or **Annually**.

## 9. Description of the user interface requirements

NEED TO DISCUSS

