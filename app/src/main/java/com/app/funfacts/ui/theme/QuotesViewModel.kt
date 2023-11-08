package com.app.funfacts.ui.theme

import androidx.lifecycle.ViewModel

class QuotesViewModel : ViewModel() {

    fun generateRandomQuotes(selectedAnimal: String): String {
        return if (selectedAnimal == "Cat") {
            getCatQuotes().random()
        } else {
            getDogQuotes().random()
        }
    }

    fun getDogQuotes(): List<String> {
        val dogQuotes = listOf(
            "Dogs are four-legged mammals that are popular domestic animals.",
            "They are highly faithful and loyal to their owners.",
            "Dogs are descendants of wolves. Their scientific name is Canis Lupus.",
            "Dogs have an excellent sense of smell. They can also hear sound frequencies that are too high for humans.",
            "Dogs are the most popular pets around the world. They have a life span of 10-15 years.",
            "Dogs fulfil many purposes starting from pet companions to guard and service animals.",
            "Females give birth to four to six puppies at a time. They nurture them until they are a few months old.",
            "Dogs have been alongside mankind for 40,000 years. Their unmatched loyalty earns them the title “Man’s best friend.",
            "Dogs bark loudly to ward off danger and to communicate.",
            "There are hundreds of breeds of dogs around the world."
        )
        return dogQuotes
    }

    fun getCatQuotes(): List<String> {
        val catQuotes = listOf(
            "Cats are carnivorous animals which are domesticated by human beings for more than 5000 years.",
            "Cats are very friendly pets that are domesticated by more than 40% of the households in the world.",
            "The average lifespan of a cat varies between 10 to 15 years.",
            "Young baby cats are known as kittens.",
            "According to scientists, more than 500 breeds of cats are known in the world.",
            "Tomcat is the term that is used to refer to male cat and Molly or queen is the term that is used to refer to female cats.",
            "Cats are furry animals that have got four legs and a tail.",
            "The sound a cat produces is called as meow, purr or hiss.",
            "A cat usually expresses love to their owners by making a sound or rolling on the floor.",
            "Cats are used by farmers to keep away rats, mice and other small animals from destroying their crops."
        )
        return catQuotes
    }
}