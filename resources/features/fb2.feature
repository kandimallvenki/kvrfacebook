Feature:Facebook Login
Background:
Given launch site
Scenario Outline: validate userid and password  field
When enter userid like "<x>" value
When enter password like "<y>" value
Then click login button
And validate userid output for "<x>" with "<Z>"  and password output for "<y>" with "<w>" criteria
Examples:
|            x                 |      z        | y         |       w       |
| kandimallavenkat1@gmail.com  |     valid     |           |  invalid      |
| kandimallavenkat1@gmail.com  |     valid     | 14597     |  invalid      |
|                              |     invalid   | 44556677  |   valid       |
|  kandimallave                |     invalid   | 44556677  |   valid       | 
| kandimallavenkat1@gmail.com  |     valid     | 44556677  |   valid       |
