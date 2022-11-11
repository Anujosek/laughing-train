Feature:Aplication Login

Scenario: Login with valid credentials
Given Open any browser
And Navigate to Login page
When User enter username as "anu.aimit.2010@gmail.com" and password as "1234"
And User clicks on Login button
Then Verify user is able to successfully login