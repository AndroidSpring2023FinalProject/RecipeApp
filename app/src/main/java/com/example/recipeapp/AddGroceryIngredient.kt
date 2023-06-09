package com.example.recipeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddGroceryIngredient : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_grocery_ingredient)


        val autoIngredientsList = arrayOf(
            "allspice.1",
            "almond.2",
            "anchovy.3",
            "anise.4",
            "apple.5",
            "apricot.6",
            "artichoke.7",
            "arugula.8",
            "asparagus.9",
            "avocado.10",
            "bacon.11",
            "baking powder.12",
            "baking soda.13",
            "banana.14",
            "basil.15",
            "bay leaf.16",
            "bean.17",
            "beef.18",
            "beet.20",
            "bell pepper.21",
            "berry.22",
            "biscuit.23",
            "black bean.24",
            "black olive.25",
            "black pepper.26",
            "blueberry.27",
            "bok choy.28",
            "bouillon.29",
            "bread.30",
            "breadcrumb.31",
            "broccoli.32",
            "brown sugar.33",
            "brussels sprouts.34",
            "butter.35",
            "buttermilk.36",
            "cabbage.37",
            "cactus.38",
            "cake flour.39",
            "candied ginger.40",
            "candy.41",
            "canned tomato.42",
            "caper.43",
            "caraway.44",
            "cardamom.45",
            "carrot.46",
            "cashew.47",
            "cauliflower.48",
            "cayenne pepper.49",
            "celery.50",
            "chai.51",
            "chamomile.52",
            "chard.53",
            "cheddar cheese.54",
            "cheese.55",
            "cherry.56",
            "chicken.57",
            "chicken broth.58",
            "chickpea.59",
            "chile pepper.60",
            "chili.61",
            "chive.62",
            "chocolate.63",
            "cilantro.64",
            "cinnamon.65",
            "clam.66",
            "cloves.67",
            "cocoa powder.68",
            "coconut.69",
            "coconut milk.70",
            "cod.71",
            "coffee.72",
            "cognac.73",
            "collard greens.74",
            "confectioners sugar.75",
            "cookie.76",
            "coriander.77",
            "corn.78",
            "corn flour.79",
            "corn syrup.80",
            "cornmeal.81",
            "cornstarch.82",
            "cottage cheese.83",
            "couscous.84",
            "cranberry.85",
            "cream.86",
            "cream cheese.87",
            "cream of tartar.88",
            "creamy peanut butter.89",
            "cucumber.90",
            "cumin.91",
            "currant.92",
            "curry.93",
            "custard.94",
            "dill.95",
            "dried fruit.96",
            "duck.97",
            "egg.98",
            "eggplant.99",
            "elderberry.100",
            "enchilada sauce.101",
            "fennel.102",
            "feta cheese.103",
            "fig.104",
            "filo dough.105",
            "fish.106",
            "flaxseed.107",
            "flour.108",
            "fondant.109",
            "fontina cheese.110",
            "food coloring.111",
            "garlic.112",
            "ginger.113",
            "ginger ale.114",
            "goat cheese.115",
            "golden raisin.116",
            "gouda cheese.117",
            "graham cracker.118",
            "grape.119",
            "grapefruit.120",
            "grapeseed oil.121",
            "green bean.122",
            "green olive.123",
            "green onion.124",
            "green pepper.125",
            "ground beef.126",
            "ground pork.127",
            "ground turkey.128",
            "guava.129",
            "habanero pepper.130",
            "halibut.131",
            "ham.132",
            "hamburger bun.133",
            "heavy cream.134",
            "honey.135",
            "honeydew.136",
            "horseradish.137",
            "hot sauce.138",
            "hummus.139",
            "ice.140",
            "icing sugar.141",
            "jack cheese.142",
            "jalapeno pepper.143",
            "jam.144",
            "jicama.145",
            "jimmies.146",
            "jollof rice seasoning.147",
            "jowl.148",
            "juniper berry.149",
            "kale.150",
            "ketchup.151",
            "kiwi.152",
            "kosher salt.153",
            "lamb.154",
            "lard.155",
            "lavender.156",
            "leek.157",
            "lemon.158",
            "lemon juice.159",
            "lentil.160",
            "lettuce.161",
            "licorice.162",
            "lime.163",
            "lime juice.164",
            "limoncello.165",
            "lingonberry.166",
            "liquid smoke.167",
            "lobster.168",
            "long grain rice.169",
            "low-fat yogurt.170",
            "macadamia nut.171",
            "macaroni.172",
            "mackerel.173",
            "madeira.174",
            "mahi-mahi.175",
            "mahlab.176",
            "malt.177",
            "malt vinegar.178",
            "mandarin orange.179",
            "mango.180",
            "maple syrup.181",
            "maraschino cherry.182",
            "margarine.183",
            "marinara sauce.184",
            "marjoram.185",
            "marsala wine.186",
            "marshmallow.187",
            "mascarpone.188",
            "mayonnaise.189",
            "meatball.190",
            "medjool dates.191",
            "melon.192",
            "meringue.193",
            "mesclun.194",
            "milk.195",
            "mint.196",
            "molasses.197",
            "monkfish.198",
            "mozzarella cheese.199",
            "mushroom.200",
            "mussels.201",
            "mustard.202",
            "mustard seed.203",
            "nacho cheese.204",
            "napa cabbage.205",
            "navy bean.206",
            "nectarine.207",
            "nigella seed.208",
            "noodle.209",
            "nutmeg.210",
            "oatmeal.211",
            "octopus.212",
            "okra.213",
            "olive.214",
            "olive oil.215",
            "onion.216",
            "orange.217",
            "orange juice.218",
            "oregano.219",
            "oyster.220",
            "oyster sauce.221",
            "pak choi.222",
            "pancake mix.223",
            "pancetta.224",
            "papaya.225",
            "paprika.226",
            "parmesan cheese.227",
            "parsley.228",
            "parsnip.229",
            "passionfruit.230",
            "pasta.231",
            "pea.232",
            "peach.233",
            "peanut.234",
            "peanut butter.235",
            "pear.236",
            "pecan.237",
            "penne.238",
            "pepper.239",
            "peppermint.240",
            "pepperoni.241",
            "persimmon.242",
            "pesto.243",
            "pickle.244",
            "pineapple.245",
            "pinto bean.246",
            "pistachio.247",
            "pizza crust.248",
            "plum.249",
            "polenta.250",
            "pomegranate.251",
            "popcorn.252",
            "poppy seed.253",
            "pork.254",
            "port wine.255",
            "potato.256",
            "potsticker wrappers.257",
            "poultry seasoning.258",
            "prawn.259",
            "pretzel.260",
            "prosciutto.261",
            "provolone cheese.262",
            "prune.263",
            "pumpkin.264",
            "pumpkin seed.265",
            "quail.266",
            "quinoa.267",
            "radicchio.268",
            "radish.269",
            "radicchio.270",
            "radish.271",
            "raisin.272",
            "raspberry.273",
            "raw sugar.274",
            "red cabbage.275",
            "red onion.276",
            "red pepper.277",
            "red wine.278",
            "red wine vinegar.279",
            "relish.280",
            "rhubarb.281",
            "rib.282",
            "rice.283",
            "ricotta cheese.284",
            "ritz crackers.285",
            "roast beef.286",
            "roasted garlic.287",
            "romaine lettuce.288",
            "rose water.289",
            "rosemary.290",
            "rum.291",
            "rutabaga.292",
            "rye bread.293",
            "saffron.294",
            "sage.295",
            "salami.296",
            "salmon.297",
            "salsa.298",
            "salt.299",
            "sardines.300",
            "sausage.301",
            "scallion.302",
            "scallops.303",
            "sea salt.304",
            "seasoning salt.305",
            "sesame oil.306",
            "sesame seed.307",
            "shallot.308",
            "sherry.309",
            "sherry vinegar.310",
            "shiitake mushroom.311",
            "shortbread cookie.312",
            "shortening.313",
            "shrimp.314",
            "skim milk.315",
            "slaw dressing.316",
            "smoked paprika.317",
            "smoked salmon.318",
            "snapper.319",
            "soba noodle.320",
            "soda water.321",
            "sour cream.322",
            "soy sauce.323",
            "spaghetti.324",
            "sparkling water.325",
            "spearmint.326",
            "spinach.327",
            "splenda.328",
            "spring roll wrappers.329",
            "squash.330",
            "sriracha.331",
            "steak.332",
            "steel cut oats.333",
            "stilton cheese.334",
            "strawberry.335",
            "stuffing mix.336",
            "sugar.337",
            "sultana.338",
            "sun-dried tomato.339",
            "sweet chili sauce.340",
            "sweet potato.341",
            "sweetened condensed milk.342",
            "swiss cheese.343",
            "swordfish.344",
            "taco seasoning.345",
            "tahini.346",
            "tamarind.347",
            "tangerine.348",
            "tapioca flour.349",
            "tarragon.350",
            "tea.351",
            "tequila.352",
            "teriyaki sauce.353",
            "thyme.354",
            "tilapia.355",
            "tofu.356",
            "tomatillo.357",
            "tomato.358",
            "tomato juice.359",
            "tomato paste.360",
            "tomato sauce.361",
            "tonic water.362",
            "trout.363",
            "truffle.364",
            "tuna.365",
            "turkey.366",
            "turmeric.367",
            "turnip.368",
            "vanilla.369",
            "vanilla bean.370",
            "vanilla extract.371",
            "vegetable broth.372",
            "vegetable oil.373",
            "venison.374",
            "vermouth.375",
            "vinegar.376",
            "vodka.377",
            "walnut.378",
            "wasabi.379",
            "water.380",
            "water chestnut.381",
            "watercress.382",
            "watermelon.383",
            "wheat bread.384",
            "whipped cream.385",
            "whiskey.386",
            "white chocolate.387",
            "white onion.388",
            "white pepper.389",
            "white wine.390",
            "white wine vinegar.391",
            "whole wheat bread.392",
            "whole wheat flour.393",
            "wild rice.394",
            "wine.395",
            "wonton wrapper.396",
            " Worcestershire sauce.397",
            "yam.398",
            "yellow onion.399",
            "yellow pepper.400",
            "yogurt.401",
            "ziti.402")
        var ingredientQuantity = findViewById<EditText>(R.id.etAddIngredientQuantity)
        var ingredient = findViewById<AutoCompleteTextView>(R.id.autoAddIngredient)
        ingredient.threshold = 1
        ingredient.setAdapter(ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, autoIngredientsList))

        val submitButton = findViewById<Button>(R.id.btnAddSubmit)
        submitButton.setOnClickListener{
            if((autoIngredientsList.contains(ingredient.text.toString())) && !(ingredientQuantity.text.toString().isEmpty())){
                val ingredientSplitArray = ingredient.text.toString().split(".")
                val addIngredient = IngredientGrocery(ingredientSplitArray[1].toLong(), ingredientSplitArray[0], ingredientQuantity.text.toString())
                GroceryIngredients.addIngredient(addIngredient)
                var currIndex = 0;

                GroceryIngredients.ingredients.forEachIndexed{index, eachIngredient ->
                    Log.d("Testing", eachIngredient.name)
                    if(ingredientSplitArray[0] == eachIngredient.name){
                        currIndex = index
                    }
                }
                lifecycleScope.launch(Dispatchers.IO){
                    (application as IngredientApplication).db.groceryDao().insert(GroceryIngredients.ingredients.get(currIndex))
                }
                ingredient.setText("")
                ingredientQuantity.setText("")
                val success = Toast.makeText(this, "Ingredient added!", Toast.LENGTH_SHORT).show()
//                setResult(1)
//                finish()
            }else{
                val notFound = Toast.makeText(this, "Ingredient not found.", Toast.LENGTH_SHORT).show()
                ingredient.setText("")
                ingredientQuantity.setText("")

            }

        }

        ingredient.setOnItemClickListener { parent, view, position, id ->
            val selectedIngredient = parent.getItemAtPosition(position).toString()
            ingredient.setText(selectedIngredient)
        }

    }


}