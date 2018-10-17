# findRecipe
# find recipe

Given the available items in the fridge and some recipes, generate a recipe for what to cook tonight.
Input part1 fridge: {Item， Amount， Unit， UseBy}
Input part2 recipe: {Name,{Ingredients: Item, Amount, Unit} }
Two inputs are from postman.

cmd script: java -jar recipefinder.jar

Postman->
Headers->Content-Type,application/json
Body->JSON

Postman Input address1:http://localhost:8080/fridge
Example json input:
[
{
"item":"bread" , "amount":"10", "unit":"slices","useBy":"25/12/2019"},
{
"item":"cheese" , "amount":"10", "unit":"slices","useBy":"19/12/2018"},
{
"item":"butter" , "amount":"250", "unit":"grams","useBy":"25/12/2014"},
{
"item":"peanut butter" , "amount":"250", "unit":"grams","useBy":"2/12/2014"},
{
"item":"mixed salad" , "amount":"150", "unit":"grams","useBy":"26/10/2019"}
]

Postman Input address2:http://localhost:8080/recipe
Example json input:
[
{
"name": "grilled cheese on toast", "ingredients": [
{ "item":"bread", "amount":"2", "unit":"slices"},
{ "item":"cheese", "amount":"2", "unit":"slices"}
]
} , {
"name": "salad sandwich",
"ingredients": [
{ "item":"bread", "amount":"2", "unit":"slices"},
{ "item":"mixed salad", "amount":"100", "unit":"grams"}
]
}
]


Output of example json data:
final recipe:grilled cheese on toast
