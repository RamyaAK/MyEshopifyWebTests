# myshopify

A simple E-commerce website Automation framework.

STEPS TO RUN TESTS ON LOCAL MACHINE
------------------------------------
1) Clone the repository
2) Open the project as gradle project (by opening build.gradle file using Intillij Idea)
3) Wait till all dependencies are downloaded
4) Add lombok plugin and enable annotation processing. (https://stackoverflow.com/questions/41161076/adding-lombok-plugin-to-intellij-project)
5) If you want to run Tests in parallel (both chorome and firefox) Run follwing command line run below command
 ./gradlew runTests

Tech Stack Used:
BUILD tool     : gradle
Language       : Java
TestingTool    : TestNG
approach       : TDD
Reporting      : Extent Report and TestNG Reporting


Stories implemented:

1) Search and add a product to cart
2) Increase product quantity and validate the price.
3) Add a product from the featured collection.
4) Add to cart, products with multiple sizes.

Features implemented:

support multiple browsers (chrome and firefox).
tests can run in parallel.
Capture screenshot on failure.
Includes Extent Reporting mechanism.


