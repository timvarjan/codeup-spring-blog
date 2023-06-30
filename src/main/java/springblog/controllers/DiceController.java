package springblog.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Random;

@Controller
@RequestMapping("/")
public class DiceController {

    private int lastGuess = 0;
    private int lastDiceRoll = 0;
    private String lastMessage = "";

    @GetMapping("/roll-dice")
    public String showRollDicePage() {
        return "roll-dice";
    }

    @GetMapping("/roll-dice/{guess}")
    public String rollDice(@PathVariable int guess, Model model) {
        Random random = new Random();
        int diceRoll = random.nextInt(6) + 1;

        lastGuess = guess;
        lastDiceRoll = diceRoll;
        lastMessage = (guess == diceRoll) ? "Congratulations, you guessed correctly!"
                : "Sorry, your guess was incorrect.";

        model.addAttribute("guess", lastGuess);
        model.addAttribute("diceRoll", lastDiceRoll);
        model.addAttribute("message", lastMessage);

        return "roll-dice-result";
    }

    @PostMapping("/reset")
    public String reset(Model model) {
        lastGuess = 0;
        lastDiceRoll = 0;
        lastMessage = "";

        return "redirect:/roll-dice";
    }
}


