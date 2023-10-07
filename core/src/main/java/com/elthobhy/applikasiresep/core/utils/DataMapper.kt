package com.elthobhy.applikasiresep.core.utils

import com.elthobhy.applikasiresep.core.data.source.local.entity.Entity
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityCategory
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityCategoryMeal
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityDetail
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntityMain
import com.elthobhy.applikasiresep.core.data.source.local.entity.EntitySearch
import com.elthobhy.applikasiresep.core.data.source.remote.response.CategoriesItem
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItem
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemDetail
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemMain
import com.elthobhy.applikasiresep.core.data.source.remote.response.MealsItemSearch
import com.elthobhy.applikasiresep.core.domain.model.Domain
import com.elthobhy.applikasiresep.core.domain.model.DomainCategory
import com.elthobhy.applikasiresep.core.domain.model.DomainDetail
import com.elthobhy.applikasiresep.core.domain.model.DomainMain
import com.elthobhy.applikasiresep.core.domain.model.DomainMeal
import com.elthobhy.applikasiresep.core.domain.model.DomainSearch

object DataMapper {
    fun entityToDomain(input: List<Entity>): List<Domain> {
        val out = ArrayList<Domain>()
        input.map {
            val list = Domain(
                strArea = it.strArea
            )
            out.add(list)
        }
        return out
    }

    fun responToEntity(input: List<MealsItem>): List<Entity> {
        val out = ArrayList<Entity>()
        input.map {
            val list = Entity(
                strArea = it.strArea
            )
            out.add(list)
        }
        return out
    }

    fun entityMainToDomainMain(input: List<EntityMain>): List<DomainMain> {
        val out = ArrayList<DomainMain>()
        input.map {
            val list = DomainMain(
                strMealThumb = it.strMealThumb,
                strMeal = it.strMeal,
                idMeal = it.idMeal
            )
            out.add(list)
        }
        return out
    }

    fun responMainToEntityMain(input: List<MealsItemMain>): List<EntityMain> {
        val out = ArrayList<EntityMain>()
        input.map {
            val list = it.idMeal?.let { it1 ->
                EntityMain(
                    strMealThumb = it.strMealThumb,
                    strMeal = it.strMeal,
                    idMeal = it1
                )
            }
            if (list != null) {
                out.add(list)
            }
        }
        return out
    }

    fun entityDetailToDomainDetail(input: List<EntityDetail>): List<DomainDetail> {
        val out = ArrayList<DomainDetail>()
        input.map {
            val list = DomainDetail(
                strImageSource = it.strImageSource,
                strIngredient10 = it.strIngredient10,
                strIngredient12 = it.strIngredient12,
                strIngredient11 = it.strIngredient11,
                strIngredient14 = it.strIngredient14,
                strCategory = it.strCategory,
                strIngredient13 = it.strIngredient13,
                strIngredient16 = it.strIngredient16,
                strIngredient15 = it.strIngredient15,
                strIngredient18 = it.strIngredient18,
                strIngredient17 = it.strIngredient17,
                strArea = it.strArea,
                strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed,
                strIngredient19 = it.strIngredient19,
                strTags = it.strTags,
                idMeal = it.idMeal,
                strInstructions = it.strInstructions,
                strIngredient1 = it.strIngredient1,
                strIngredient3 = it.strIngredient3,
                strIngredient2 = it.strIngredient2,
                strIngredient20 = it.strIngredient20,
                strIngredient5 = it.strIngredient5,
                strIngredient4 = it.strIngredient4,
                strIngredient7 = it.strIngredient7,
                strIngredient6 = it.strIngredient6,
                strIngredient9 = it.strIngredient9,
                strIngredient8 = it.strIngredient8,
                strMealThumb = it.strMealThumb,
                strMeasure20 = it.strMeasure20,
                strYoutube = it.strYoutube,
                strMeal = it.strMeal,
                strMeasure12 = it.strMeasure12,
                strMeasure13 = it.strMeasure13,
                strMeasure10 = it.strMeasure10,
                strMeasure11 = it.strMeasure11,
                dateModified = it.dateModified,
                strDrinkAlternate = it.strDrinkAlternate,
                strSource = it.strSource,
                strMeasure9 = it.strMeasure9,
                strMeasure7 = it.strMeasure7,
                strMeasure8 = it.strMeasure8,
                strMeasure5 = it.strMeasure5,
                strMeasure6 = it.strMeasure6,
                strMeasure3 = it.strMeasure3,
                strMeasure4 = it.strMeasure4,
                strMeasure1 = it.strMeasure1,
                strMeasure18 = it.strMeasure18,
                strMeasure2 = it.strMeasure2,
                strMeasure19 = it.strMeasure19,
                strMeasure16 = it.strMeasure16,
                strMeasure17 = it.strMeasure17,
                strMeasure14 = it.strMeasure14,
                strMeasure15 = it.strMeasure15,
                isFavorite = it.isFavorite
            )
            out.add(list)
        }
        return out
    }

    fun responDetailToEntityDetail(input: List<MealsItemDetail>): List<EntityDetail> {
        val out = ArrayList<EntityDetail>()
        input.map {
            val list = it.idMeal?.let { it1 ->
                EntityDetail(
                    strImageSource = it.strImageSource,
                    strIngredient10 = it.strIngredient10,
                    strIngredient12 = it.strIngredient12,
                    strIngredient11 = it.strIngredient11,
                    strIngredient14 = it.strIngredient14,
                    strCategory = it.strCategory,
                    strIngredient13 = it.strIngredient13,
                    strIngredient16 = it.strIngredient16,
                    strIngredient15 = it.strIngredient15,
                    strIngredient18 = it.strIngredient18,
                    strIngredient17 = it.strIngredient17,
                    strArea = it.strArea,
                    strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed,
                    strIngredient19 = it.strIngredient19,
                    strTags = it1,
                    idMeal = it.idMeal,
                    strInstructions = it.strInstructions,
                    strIngredient1 = it.strIngredient1,
                    strIngredient3 = it.strIngredient3,
                    strIngredient2 = it.strIngredient2,
                    strIngredient20 = it.strIngredient20,
                    strIngredient5 = it.strIngredient5,
                    strIngredient4 = it.strIngredient4,
                    strIngredient7 = it.strIngredient7,
                    strIngredient6 = it.strIngredient6,
                    strIngredient9 = it.strIngredient9,
                    strIngredient8 = it.strIngredient8,
                    strMealThumb = it.strMealThumb,
                    strMeasure20 = it.strMeasure20,
                    strYoutube = it.strYoutube,
                    strMeal = it.strMeal,
                    strMeasure12 = it.strMeasure12,
                    strMeasure13 = it.strMeasure13,
                    strMeasure10 = it.strMeasure10,
                    strMeasure11 = it.strMeasure11,
                    dateModified = it.dateModified,
                    strDrinkAlternate = it.strDrinkAlternate,
                    strSource = it.strSource,
                    strMeasure9 = it.strMeasure9,
                    strMeasure7 = it.strMeasure7,
                    strMeasure8 = it.strMeasure8,
                    strMeasure5 = it.strMeasure5,
                    strMeasure6 = it.strMeasure6,
                    strMeasure3 = it.strMeasure3,
                    strMeasure4 = it.strMeasure4,
                    strMeasure1 = it.strMeasure1,
                    strMeasure18 = it.strMeasure18,
                    strMeasure2 = it.strMeasure2,
                    strMeasure19 = it.strMeasure19,
                    strMeasure16 = it.strMeasure16,
                    strMeasure17 = it.strMeasure17,
                    strMeasure14 = it.strMeasure14,
                    strMeasure15 = it.strMeasure15,
                )
            }
            if (list != null) {
                out.add(list)
            }
        }
        return out
    }

    fun entitySearchToDomainSearch(input: List<EntitySearch>): List<DomainSearch> {
        val out = ArrayList<DomainSearch>()
        input.map {
            val list = DomainSearch(
                strImageSource = it.strImageSource,
                strIngredient10 = it.strIngredient10,
                strIngredient12 = it.strIngredient12,
                strIngredient11 = it.strIngredient11,
                strIngredient14 = it.strIngredient14,
                strCategory = it.strCategory,
                strIngredient13 = it.strIngredient13,
                strIngredient16 = it.strIngredient16,
                strIngredient15 = it.strIngredient15,
                strIngredient18 = it.strIngredient18,
                strIngredient17 = it.strIngredient17,
                strArea = it.strArea,
                strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed,
                strIngredient19 = it.strIngredient19,
                strTags = it.strTags,
                idMeal = it.idMeal,
                strInstructions = it.strInstructions,
                strIngredient1 = it.strIngredient1,
                strIngredient3 = it.strIngredient3,
                strIngredient2 = it.strIngredient2,
                strIngredient20 = it.strIngredient20,
                strIngredient5 = it.strIngredient5,
                strIngredient4 = it.strIngredient4,
                strIngredient7 = it.strIngredient7,
                strIngredient6 = it.strIngredient6,
                strIngredient9 = it.strIngredient9,
                strIngredient8 = it.strIngredient8,
                strMealThumb = it.strMealThumb,
                strMeasure20 = it.strMeasure20,
                strYoutube = it.strYoutube,
                strMeal = it.strMeal,
                strMeasure12 = it.strMeasure12,
                strMeasure13 = it.strMeasure13,
                strMeasure10 = it.strMeasure10,
                strMeasure11 = it.strMeasure11,
                dateModified = it.dateModified,
                strDrinkAlternate = it.strDrinkAlternate,
                strSource = it.strSource,
                strMeasure9 = it.strMeasure9,
                strMeasure7 = it.strMeasure7,
                strMeasure8 = it.strMeasure8,
                strMeasure5 = it.strMeasure5,
                strMeasure6 = it.strMeasure6,
                strMeasure3 = it.strMeasure3,
                strMeasure4 = it.strMeasure4,
                strMeasure1 = it.strMeasure1,
                strMeasure18 = it.strMeasure18,
                strMeasure2 = it.strMeasure2,
                strMeasure19 = it.strMeasure19,
                strMeasure16 = it.strMeasure16,
                strMeasure17 = it.strMeasure17,
                strMeasure14 = it.strMeasure14,
                strMeasure15 = it.strMeasure15,
            )
            out.add(list)
        }
        return out
    }

    fun responSearchToEntitySearch(input: List<MealsItemSearch>): List<EntitySearch> {
        val out = ArrayList<EntitySearch>()
        input.map {
            val list = it.idMeal?.let { it1 ->
                EntitySearch(
                    strImageSource = it.strImageSource,
                    strIngredient10 = it.strIngredient10,
                    strIngredient12 = it.strIngredient12,
                    strIngredient11 = it.strIngredient11,
                    strIngredient14 = it.strIngredient14,
                    strCategory = it.strCategory,
                    strIngredient13 = it.strIngredient13,
                    strIngredient16 = it.strIngredient16,
                    strIngredient15 = it.strIngredient15,
                    strIngredient18 = it.strIngredient18,
                    strIngredient17 = it.strIngredient17,
                    strArea = it.strArea,
                    strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed,
                    strIngredient19 = it.strIngredient19,
                    strTags = it1,
                    idMeal = it.idMeal,
                    strInstructions = it.strInstructions,
                    strIngredient1 = it.strIngredient1,
                    strIngredient3 = it.strIngredient3,
                    strIngredient2 = it.strIngredient2,
                    strIngredient20 = it.strIngredient20,
                    strIngredient5 = it.strIngredient5,
                    strIngredient4 = it.strIngredient4,
                    strIngredient7 = it.strIngredient7,
                    strIngredient6 = it.strIngredient6,
                    strIngredient9 = it.strIngredient9,
                    strIngredient8 = it.strIngredient8,
                    strMealThumb = it.strMealThumb,
                    strMeasure20 = it.strMeasure20,
                    strYoutube = it.strYoutube,
                    strMeal = it.strMeal,
                    strMeasure12 = it.strMeasure12,
                    strMeasure13 = it.strMeasure13,
                    strMeasure10 = it.strMeasure10,
                    strMeasure11 = it.strMeasure11,
                    dateModified = it.dateModified,
                    strDrinkAlternate = it.strDrinkAlternate,
                    strSource = it.strSource,
                    strMeasure9 = it.strMeasure9,
                    strMeasure7 = it.strMeasure7,
                    strMeasure8 = it.strMeasure8,
                    strMeasure5 = it.strMeasure5,
                    strMeasure6 = it.strMeasure6,
                    strMeasure3 = it.strMeasure3,
                    strMeasure4 = it.strMeasure4,
                    strMeasure1 = it.strMeasure1,
                    strMeasure18 = it.strMeasure18,
                    strMeasure2 = it.strMeasure2,
                    strMeasure19 = it.strMeasure19,
                    strMeasure16 = it.strMeasure16,
                    strMeasure17 = it.strMeasure17,
                    strMeasure14 = it.strMeasure14,
                    strMeasure15 = it.strMeasure15,
                )
            }
            if (list != null) {
                out.add(list)
            }
        }
        return out
    }

    fun entityCategoryToDomainCategory(input: List<EntityCategory>): List<DomainCategory> {
        val out = ArrayList<DomainCategory>()
        input.map {
            val list = DomainCategory(
                idCategory = it.idCategory,
                strCategory = it.strCategory,
                strCategoryDescription = it.strCategoryDescription,
                strCategoryThumb = it.strCategoryThumb
            )
            out.add(list)
        }
        return out
    }

    fun responCategoryToEntityCategory(input: List<CategoriesItem>): List<EntityCategory> {
        val out = ArrayList<EntityCategory>()
        input.map {
            val list = it.idCategory?.let { it1 ->
                EntityCategory(
                    idCategory = it1,
                    strCategoryThumb = it.strCategoryThumb,
                    strCategoryDescription = it.strCategoryDescription,
                    strCategory = it.strCategory
                )
            }
            if (list != null) {
                out.add(list)
            }
        }
        return out
    }

    fun entityMealToDomainMeal(input: List<EntityCategoryMeal>): List<DomainMeal> {
        val out = ArrayList<DomainMeal>()
        input.map {
            val list = DomainMeal(
                strMealThumb = it.strMealThumb,
                strMeal = it.strMeal,
                idMeal = it.idMeal,
                isBeef = it.isBeef,
                isBreakfast = it.isBreakfast,
                isChicken = it.isChicken,
                isDessert = it.isDessert,
                isGoat = it.isGoat,
                isLamb = it.isLamb,
                isMiscellaneous = it.isMiscellaneous,
                isPasta = it.isPasta,
                isPork = it.isPork,
                isSeafood = it.isSeafood,
                isSide = it.isSide,
                isStarter = it.isStarter,
                isVegan = it.isVegan,
                isVegetarian = it.isVegetarian
            )
            out.add(list)
        }
        return out
    }

    fun responMealToEntityMeal(input: List<MealsItemMain>,isBeef: Boolean,
                               isBreakfast: Boolean,
                               isChicken: Boolean,
                               isDessert: Boolean,
                               isGoat: Boolean,
                               isLamb: Boolean,
                               isMiscellaneous: Boolean,
                               isPasta: Boolean,
                               isPork: Boolean,
                               isSeafood: Boolean,
                               isSide: Boolean,
                               isStarter: Boolean,
                               isVegan: Boolean,
                               isVegetarian: Boolean,): List<EntityCategoryMeal> {
        val out = ArrayList<EntityCategoryMeal>()
        input.map {
            val list = it.idMeal?.let { it1 ->
                EntityCategoryMeal(
                    strMealThumb = it.strMealThumb,
                    strMeal = it.strMeal,
                    idMeal = it1,
                    isBeef = isBeef,
                    isBreakfast = isBreakfast,
                    isChicken = isChicken,
                    isDessert = isDessert,
                    isGoat = isGoat,
                    isLamb = isLamb,
                    isMiscellaneous = isMiscellaneous,
                    isPasta = isPasta,
                    isPork = isPork,
                    isSeafood = isSeafood,
                    isSide = isSide,
                    isStarter = isStarter,
                    isVegan = isVegan,
                    isVegetarian = isVegetarian
                )
            }
            if (list != null) {
                out.add(list)
            }
        }
        return out
    }

    fun domainMealToEntityMeal(data: List<DomainMeal>): List<EntityCategoryMeal> {
        val out = ArrayList<EntityCategoryMeal>()
        data.map {
            val list = EntityCategoryMeal(
                idMeal = it.idMeal,
                strMeal = it.strMeal,
                strMealThumb = it.strMealThumb,
                isBeef = it.isBeef,
                isBreakfast = it.isBreakfast,
                isChicken = it.isChicken,
                isDessert = it.isDessert,
                isGoat = it.isGoat,
                isLamb = it.isLamb,
                isMiscellaneous = it.isMiscellaneous,
                isPasta = it.isPasta,
                isPork = it.isPork,
                isSeafood = it.isSeafood,
                isSide = it.isSide,
                isStarter = it.isStarter,
                isVegan = it.isVegan,
                isVegetarian = it.isVegetarian
            )
            out.add(list)
        }
        return out
    }

    fun entityStarterToDomainStarter(input: List<EntityCategoryMeal>): List<DomainMeal> =
        input.map {
            DomainMeal(
                isStarter =it.isStarter,
                isVegan =it.isVegan,
                isSide =it.isSide,
                isSeafood =it.isSeafood,
                isPork =it.isPork,
                isPasta =it.isPasta,
                isMiscellaneous =it.isMiscellaneous,
                isLamb =it.isLamb,
                isGoat =it.isGoat,
                isDessert =it.isDessert,
                isChicken =it.isChicken,
                isBreakfast =it.isBreakfast,
                isBeef =it.isBeef,
                strMealThumb =it.strMealThumb,
                strMeal =it.strMeal,
                idMeal =it.idMeal,
                isVegetarian =it.isVegetarian
            )
        }

    fun domainToEntity(it: DomainDetail): EntityDetail? =
        it.idMeal?.let { it1 ->
            EntityDetail(
                strImageSource = it.strImageSource,
                strIngredient10 = it.strIngredient10,
                strIngredient12 = it.strIngredient12,
                strIngredient11 = it.strIngredient11,
                strIngredient14 = it.strIngredient14,
                strCategory = it.strCategory,
                strIngredient13 = it.strIngredient13,
                strIngredient16 = it.strIngredient16,
                strIngredient15 = it.strIngredient15,
                strIngredient18 = it.strIngredient18,
                strIngredient17 = it.strIngredient17,
                strArea = it.strArea,
                strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed,
                strIngredient19 = it.strIngredient19,
                strTags = it.strTags,
                idMeal = it1,
                strInstructions = it.strInstructions,
                strIngredient1 = it.strIngredient1,
                strIngredient3 = it.strIngredient3,
                strIngredient2 = it.strIngredient2,
                strIngredient20 = it.strIngredient20,
                strIngredient5 = it.strIngredient5,
                strIngredient4 = it.strIngredient4,
                strIngredient7 = it.strIngredient7,
                strIngredient6 = it.strIngredient6,
                strIngredient9 = it.strIngredient9,
                strIngredient8 = it.strIngredient8,
                strMealThumb = it.strMealThumb,
                strMeasure20 = it.strMeasure20,
                strYoutube = it.strYoutube,
                strMeal = it.strMeal,
                strMeasure12 = it.strMeasure12,
                strMeasure13 = it.strMeasure13,
                strMeasure10 = it.strMeasure10,
                strMeasure11 = it.strMeasure11,
                dateModified = it.dateModified,
                strDrinkAlternate = it.strDrinkAlternate,
                strSource = it.strSource,
                strMeasure9 = it.strMeasure9,
                strMeasure7 = it.strMeasure7,
                strMeasure8 = it.strMeasure8,
                strMeasure5 = it.strMeasure5,
                strMeasure6 = it.strMeasure6,
                strMeasure3 = it.strMeasure3,
                strMeasure4 = it.strMeasure4,
                strMeasure1 = it.strMeasure1,
                strMeasure18 = it.strMeasure18,
                strMeasure2 = it.strMeasure2,
                strMeasure19 = it.strMeasure19,
                strMeasure16 = it.strMeasure16,
                strMeasure17 = it.strMeasure17,
                strMeasure14 = it.strMeasure14,
                strMeasure15 = it.strMeasure15,
                isFavorite = it.isFavorite
            )
        }

    fun domainDetailToEntityDetail(data: List<DomainDetail>?): List<EntityDetail> {
        val out = ArrayList<EntityDetail>()
        data?.map {
            val list = it.idMeal?.let { it1 ->
                EntityDetail(
                    strImageSource = it.strImageSource,
                    strIngredient10 = it.strIngredient10,
                    strIngredient12 = it.strIngredient12,
                    strIngredient11 = it.strIngredient11,
                    strIngredient14 = it.strIngredient14,
                    strCategory = it.strCategory,
                    strIngredient13 = it.strIngredient13,
                    strIngredient16 = it.strIngredient16,
                    strIngredient15 = it.strIngredient15,
                    strIngredient18 = it.strIngredient18,
                    strIngredient17 = it.strIngredient17,
                    strArea = it.strArea,
                    strCreativeCommonsConfirmed = it.strCreativeCommonsConfirmed,
                    strIngredient19 = it.strIngredient19,
                    strTags = it.strTags,
                    idMeal = it1,
                    strInstructions = it.strInstructions,
                    strIngredient1 = it.strIngredient1,
                    strIngredient3 = it.strIngredient3,
                    strIngredient2 = it.strIngredient2,
                    strIngredient20 = it.strIngredient20,
                    strIngredient5 = it.strIngredient5,
                    strIngredient4 = it.strIngredient4,
                    strIngredient7 = it.strIngredient7,
                    strIngredient6 = it.strIngredient6,
                    strIngredient9 = it.strIngredient9,
                    strIngredient8 = it.strIngredient8,
                    strMealThumb = it.strMealThumb,
                    strMeasure20 = it.strMeasure20,
                    strYoutube = it.strYoutube,
                    strMeal = it.strMeal,
                    strMeasure12 = it.strMeasure12,
                    strMeasure13 = it.strMeasure13,
                    strMeasure10 = it.strMeasure10,
                    strMeasure11 = it.strMeasure11,
                    dateModified = it.dateModified,
                    strDrinkAlternate = it.strDrinkAlternate,
                    strSource = it.strSource,
                    strMeasure9 = it.strMeasure9,
                    strMeasure7 = it.strMeasure7,
                    strMeasure8 = it.strMeasure8,
                    strMeasure5 = it.strMeasure5,
                    strMeasure6 = it.strMeasure6,
                    strMeasure3 = it.strMeasure3,
                    strMeasure4 = it.strMeasure4,
                    strMeasure1 = it.strMeasure1,
                    strMeasure18 = it.strMeasure18,
                    strMeasure2 = it.strMeasure2,
                    strMeasure19 = it.strMeasure19,
                    strMeasure16 = it.strMeasure16,
                    strMeasure17 = it.strMeasure17,
                    strMeasure14 = it.strMeasure14,
                    strMeasure15 = it.strMeasure15,
                    isFavorite = it.isFavorite
                )
            }
            if (list != null) {
                out.add(list)
            }
        }
        return out
    }
}