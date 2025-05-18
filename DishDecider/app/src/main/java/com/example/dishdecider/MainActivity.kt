package com.example.dishdecider

import android.content.Intent
import android.view.View
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    data class Recipe(
        val ingredients: Set<String>,
        val mealType: String,
        val dish: String,
        val description: String,
        val imageResId: Int
    )

    private val recipeList = listOf(
        Recipe(setOf("Eggs", "Tomatoes", "Cheese"), "Breakfast", "Cheesy Omelette", "A fluffy omelette packed with juicy tomatoes and melted cheese, perfect for a quick and satisfying breakfast. The creamy texture and burst of tomato flavor make it a comforting morning favorite.\n" +
                "\n", R.drawable.cheesy_omelette),
        Recipe(setOf("Bread", "Eggs", "Milk"), "Breakfast", "French Toast", "Golden slices of bread soaked in a sweet egg-milk mixture, then pan-fried to perfection. Topped with syrup or fruit, it’s a delightful way to start your day.\n" +
                "\n", R.drawable.french_toast),
        Recipe(setOf("Banana", "Oats", "Milk"), "Breakfast", "Banana Oatmeal", "A wholesome bowl of creamy oats blended with banana slices, perfect for a nutritious start. It keeps you full for hours while offering a naturally sweet flavor.\n" +
                "\n", R.drawable.oatmeal),

        Recipe(setOf("Chicken", "Rice", "Soy Sauce", "Egg"), "Lunch", "Teriyaki Chicken Rice Bowl", "Tender chicken glazed in teriyaki sauce served with rice and egg. The rich, savory taste pairs perfectly with the softness of steamed rice.\n" +
                "\n", R.drawable.teriyaki),
        Recipe(setOf("Shrimp", "Rice", "Peas"), "Lunch", "Shrimp Fried Rice", "Savory fried rice with juicy shrimp and vegetables. Every bite offers a delicious mix of textures and bold Asian-inspired flavors.\n" +
                "\n", R.drawable.shrimp_fried_rice),

        Recipe(setOf("Pasta", "Garlic", "Olive Oil"), "Dinner", "Garlic Aglio e Olio", "A classic Italian pasta tossed in garlic and olive oil. Simple yet satisfying, it delivers rich taste with minimal ingredients.\n" +
                "\n", R.drawable.aglio_olio),
        Recipe(setOf("Chicken", "Carrots", "Noodles", "Broccoli"), "Dinner", "Chicken Noodle Soup", "Comforting soup made with chicken, veggies, and noodles. Perfect for chilly days, it brings warmth and nourishment in every spoonful.\n" +
                "\n", R.drawable.noodle_soup),

        Recipe(setOf("Potatoes", "Cheese", "Butter"), "Snack", "Loaded Potato Bites", "Crispy bites of potato topped with cheese and butter. This indulgent snack melts in your mouth and leaves you craving more.\n" +
                "\n", R.drawable.potato_bites),

        Recipe(setOf("Flour", "Eggs", "Sugar"), "Dessert", "Chocolate Mug Cake", "Quick microwave cake rich in chocolate and ready in minutes. It’s a fuss-free dessert that satisfies your sweet tooth instantly.\n" +
                "\n", R.drawable.mug_cake),
        Recipe(setOf("Chocolate", "Flour", "Egg"), "Dessert", "Chocolate Lava Cake", "A warm chocolate cake with a gooey molten center. The rich chocolate lava inside makes it feel like a decadent treat straight from a bakery.\n" +
                "\n", R.drawable.lava_cake)
    )

    private lateinit var mealTypeBtn: Button
    private lateinit var ingredientsBtn: Button
    private lateinit var findBtn: Button
    private lateinit var infoBtn: ImageButton
    private lateinit var imagePoster: ImageView
    private lateinit var dishTitle: TextView
    private lateinit var dishDescription: TextView

    private var selectedMealType = ""
    private var selectedIngredients = emptySet<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mealTypeBtn = findViewById(R.id.MealButton)
        ingredientsBtn = findViewById(R.id.ingredientsButton)
        findBtn = findViewById(R.id.FindButton)
        infoBtn = findViewById(R.id.infoButton)
        imagePoster = findViewById(R.id.dishImage)
        dishTitle = findViewById(R.id.dishTitle)
        dishDescription = findViewById(R.id.dishDescription)

        infoBtn.setOnClickListener {
            val intent = Intent(this, InfoModalActivity::class.java)
            startActivity(intent)
        }

        val mealTypes = recipeList.map { it.mealType }.distinct()

        mealTypeBtn.setOnClickListener {
            showSingleChoiceDialog("Select Meal Type", mealTypes) { selection ->
                selectedMealType = selection
                mealTypeBtn.text = selection
                ingredientsBtn.text = "Select Ingredients"
                selectedIngredients = emptySet()
            }
        }

        ingredientsBtn.setOnClickListener {
            if (selectedMealType.isEmpty()) {
                Toast.makeText(this, "Please select a meal type first.", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val mealsByGroup = recipeList.filter { it.mealType == selectedMealType }

            val displayMeals = mealsByGroup.mapIndexed { index, recipe ->
                "Meal ${index + 1}: " + recipe.ingredients.joinToString(", ")
            }

            showSingleChoiceDialog("Select a Meal", displayMeals) { selected ->
                val index = displayMeals.indexOf(selected)
                selectedIngredients = mealsByGroup[index].ingredients
                ingredientsBtn.text = "Meal ${index + 1}"
            }
        }

        findBtn.setOnClickListener {
            val match = recipeList.find {
                it.mealType == selectedMealType && it.ingredients == selectedIngredients
            }

            if (match != null) {
                imagePoster.setImageResource(match.imageResId)
                dishTitle.text = match.dish
                dishDescription.text = match.description

                // Make sure the views are visible
                imagePoster.visibility = View.VISIBLE
                dishTitle.visibility = View.VISIBLE
                dishDescription.visibility = View.VISIBLE
            } else {
                Toast.makeText(this, "No matching recipe found.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showSingleChoiceDialog(title: String, items: List<String>, onSelectionDone: (String) -> Unit) {
        val builder = android.app.AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setItems(items.toTypedArray()) { _, which ->
            onSelectionDone(items[which])
        }
        builder.show()
    }
}


