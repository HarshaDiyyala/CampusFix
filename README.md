# CampusFix — Smart Campus Issue Reporting & Resolution Tracker

CampusFix is a Java Dynamic Web Project that gives students a simple way to report campus problems and lets staff update their progress.

## Why this concept?
Instead of a generic student record system, CampusFix addresses a real campus problem: maintenance requests get lost in chats or verbal communication. Each report gets a tracking ID and a visible status.

## Features
- Student issue reporting with name, college email, category, location and description
- Auto-generated report tracking IDs
- Recent reports feed
- Staff dashboard with total / in-progress / resolved counts
- Staff can update report status and add an update note
- Responsive UI

## Technology
- Java 17
- JSP
- Jakarta Servlet 6
- HTML and CSS
- Eclipse IDE for Enterprise Java and Web Developers
- Apache Tomcat 10.1

## Run in Eclipse
1. Extract `CampusFix.zip`.
2. Open Eclipse.
3. Select **File → Import → General → Existing Projects into Workspace**.
4. Browse to the extracted `CampusFix` folder and click **Finish**.
5. Open the **Servers** tab. If needed, create a server using **Apache → Tomcat v10.1 Server** and select your Tomcat installation folder.
6. Right-click the project → **Properties → Targeted Runtimes** → tick **Apache Tomcat v10.1** → Apply and Close.
7. Right-click the project → **Run As → Run on Server**.
8. Choose Tomcat 10.1 and click **Finish**.
9. Open `http://localhost:8080/CampusFix/`.

## Try it
- Submit a sample issue from the home page.
- Your tracking ID appears in a success message.
- Click **Staff dashboard** in the top-right navigation.
- Change the issue status to In Progress or Resolved and save.

## Important demo limitation
This starter version stores reports in server memory. They reset when Tomcat restarts. The staff dashboard is a demo view and does not yet have authentication. For a real deployment, add a database (MySQL), staff login/role checks, validation and security protections.

## Push to GitHub
Create an empty GitHub repository, then open a terminal in the extracted project folder:

```bash
git init
git add .
git commit -m "Initial commit - CampusFix"
git branch -M main
git remote add origin https://github.com/YOUR-USERNAME/CampusFix.git
git push -u origin main
```

Replace the remote URL with your own repository URL.
