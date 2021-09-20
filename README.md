# iMinds

## Database
### Create Database for Local Developemnt
```
mysql -u root
CREATE USER 'iminds'@'localhost' IDENTIFIED BY 'iminds123';
CREATE DATABASE iminds;
GRANT ALL ON iminds.* TO 'iminds'@'localhost';
EXIT

```

### Clear Database
```
mysql -u root
DROP DATABASE iminds;
CREATE DATABASE iminds;
GRANT ALL ON iminds.* TO 'iminds'@'localhost';
EXIT

```

## Server

### Launch Server Locally
```
mvnw
```

### Run Tests

To run all tests:
```
mvnw verify
```

## Mobile Application (for participants)

### Install Packages
```
npm install
```

### Install Device Plugins
```
npm install
ionic cap sync
```

### Check Ionic is up-to-date

You need to build this project with a version of Ionic > `6.12.2`

 * Check the current version: `ionic --version`
 * Uninstall an old version: `npm uninstall -g ionic`
 * Check there are no other versions hiding: `ionic --version`
 * Install the latest version: `npm install -g @ionic/cli`
 * Check you have the latest version: `ionic --version`

### Launch In Browser
```
ionic serve
```

### Build & Add Platforms
```
npm run build
ionic cap add ios
ionic cap add android
```

### Open Platform Specific IDE
These commands will open either Android Studio or XCode, to compile and deploy.
```
ionic cap open ios
ionic cap open android
```

### Run Tests

#### End-to-End
```
ionic serve
npx cypress open --browser chrome
```
(npx comes installed with npm v5.2.0 or later)

##### Possible Cypress Issues
If Cypress gets stuck on it's smoke test when launching, these steps may help.
 * Restart your PC
 * [Turn on Debugging for Cypress](https://docs.cypress.io/guides/references/troubleshooting.html#Print-DEBUG-logs)
 * Clear out any cached versions of Cypress `npx cypress cache clear`
 * Install a fresh download of Cypress `npx cypress install` (can take a while!)
 * Try another restart

## Web Application (for researchers)


### Install Packacges
```
npm install
```

### Launch During Development
```
npm run serve
```

### Build for Production
```
npm run build
```


### Run End-to-End Tests
```
npm run test:e2e
```

