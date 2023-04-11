# Milestone 1-RecipeApp

## Table of Contents

1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)

## Overview

### Description

This app will be perfect for those who love to stay organized when they are grocery shopping. With features including tracking everything you buy at the store
recipes chosen just for you based on what you have available, and custom recipe creation, this app will be fun and easy to use for all

### App Evaluation

Description:Website that takes in information on people’s groceries and creates menus from it.
Category:Wellness website
Mobile: yes
Story: Already created recipes from already available items.
Market: The health nut. The designated home cooker. College students
Habit: When there is a new recipe created there is a red notification bar.
Scope: Everyone interested in being healthy, cutting time off from thinking of what to make.

## Product Spec

### 1. User Features (Required and Optional)

**Required Features**

* User is able to input a grocery item into an search box and choose the closest match
* User is able to add quantity to the item
* User is able to add the item to the fridge database
* User is able to move between tabs using a navigation bar
* User is able to scroll recipes on the recipes tab 
* User is able to select a desired recipe
* User is able to scroll recpie instructions on the detail recipe view
* User is able to denote whether the recipe was cooked 
* User is able to nagivate back to the recipes list
* User is able to view items in the fridge database to make edits

**Stretch Features**

* update the database when recipees are cooked 
* Implement a button to reset the fridge database 
* Create a custom recipees tab to add a users own recipees


### 2. Screen Archetypes

- Main Screen
  - Where the user can see whats in the fridge database and make edits
  
- Grocery List Screen
  - Where the user can add items to a grocery list, inputting them into the fridge database
  
 -Recipes Screen
  - Where the user can scroll a list of recipes based on their fridge database
  
 -Detail Recipe Screen
  - Where a user can view the details and steps of a chosen recipe
 
 -Custome Recipe Screen
  - Where a user can input a custom recipe that would also be considered against the database
 
### 3. Navigation

**Tab Navigation** (Tab to Screen)

* fridge tab
* grocery lsit tab
* recipes tab
* custome recipees tab

**Flow Navigation** (Screen to Screen)

Fridge Screen(default fragment)
- view all the items in the fridge database stored in room library
- the user will be able to scroll items in the fridge library
- the user will be able to delete items in the library 
- the user would naturally switch to the grocery tab 

Grocery List Screen
- The grocery input 
- User will type into a text box and input would be auto populated for simplicity
- once the item is selected, the user will press the add button, to add the item into the database
- user can repeate to include multiple items
- user will switch to the recipes tab using navigation toolbar

Recipes Fragment
- User will scroll through a list of recipes possible to make dependant on database
- User will select a recipe which will bring you to the next screen

Detail Recipe
- User will scroll through the steps of the recipe
- User will either press the cook button or the back button to continue looking at other recipes 

Custom Recipe
- the user will be able to add a custom recipe by adding steps 
- a user will be able to cook a custom recipe using a cook button and items used will be deleted from the database

## Wireframes


<img src="https://github.com/IntermediateAndroidSpring2023/RecipeApp/blob/main/RecipeWireFrameUpdated.jpg" width=600>

