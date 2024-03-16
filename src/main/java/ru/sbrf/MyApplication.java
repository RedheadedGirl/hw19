package ru.sbrf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.sbrf.entity.ComponentEntity;
import ru.sbrf.entity.RecipeEntity;
import ru.sbrf.entity.RecipesComponentsEntity;
import ru.sbrf.service.CookingBookService;

import java.util.Scanner;

@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        var factory = SpringApplication.run(MyApplication.class);
        var cookingBookService = factory.getBean(CookingBookService.class);
        Scanner scanner = new Scanner(System.in);
        System.out.println("1 - find a recipe, 2 - add a recipe, 3 - delete, 0 - exit:");

        while(scanner.hasNext()) {
            String input = scanner.next();
            switch (input) {
                case "0":
                    System.exit(0);
                    break;
                case "1":
                    System.out.println("Enter a recipe name:");
                    cookingBookService.findRecipeByName(scanner.next());
                    break;
                case "2":
                    addRecipe(scanner, cookingBookService);
                    break;
                case "3":
                    System.out.println("Enter a full recipe name, which must be deleted");
                    cookingBookService.deleteRecipe(scanner.next());
                    break;
                default:
                    System.out.println("Повторите ввод");
            }
            System.out.println("\n1 - find a recipe, 2 - add a recipe, 3 - delete, 0 - exit:");
        }

    }

    private static void addRecipe(Scanner scanner, CookingBookService cookingBookService) {
        System.out.println("Enter a recipe name:");
        RecipeEntity recipeEntity = cookingBookService.saveRecipe(new RecipeEntity(scanner.next()));
        while (true) {
            System.out.println("Enter a component name, 0 - to stop inserting components:");
            String name = scanner.next();
            if (name.equals("0")) {
                break;
            }
            System.out.println("Enter amount:");
            while (true) {
                try {
                    int amount = scanner.nextInt();
                    ComponentEntity componentEntity = cookingBookService.saveComponent(new ComponentEntity(name));
                    RecipesComponentsEntity recipesComponents =
                            new RecipesComponentsEntity(recipeEntity, componentEntity, amount);
                    cookingBookService.saveRecipeComponent(recipesComponents);
                    break;
                } catch (Exception exception) {
                    System.out.println("Wrong input, please repeat");
                    scanner = new Scanner(System.in);
                }
            }
        }
    }

}