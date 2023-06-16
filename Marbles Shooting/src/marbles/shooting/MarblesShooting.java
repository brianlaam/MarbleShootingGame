package marbles.shooting;

import javax.swing.JOptionPane;
import java.util.Random;

public class MarblesShooting {
    
    public void displayMessage (int money, int marble)
    { 
        JOptionPane.showMessageDialog(null, "You now have $" + money + " and " + marble + " marbles.");  
    }
    
    
    public static void main(String[] args) {
        MarblesShooting player = new MarblesShooting();
        int player_marble = 500;
        int player_money = 1000;
        int result3;
        int buy_marble_num = 0;
        int gamble_num = 0;
        
        player.displayMessage(player_money, player_marble);
        JOptionPane.showMessageDialog(null, "You can buy 1 marble using $1");          

        do
        {
            if (player_marble == 0)
            {
                JOptionPane.showMessageDialog(null, "You got NO marbles. You have to buy some!");               
                do
                {
                    if ((buy_marble_num > player_money) || buy_marble_num < 0)
                        JOptionPane.showMessageDialog(null, "Invalid! Please try again.");     
                    
                    String buy_marble_text = JOptionPane.showInputDialog(null, "How many marbles you want to buy?");
                    buy_marble_num = Integer.parseInt(buy_marble_text);                               
                } while (buy_marble_num > player_money || buy_marble_num < 0);
                player_money -= buy_marble_num; 
                player_marble += buy_marble_num;
                player.displayMessage(player_money, player_marble);
            }
            else
            {
                if (player_money != 0)
                {
                    int result2 = JOptionPane.showConfirmDialog(null, "Do you want to buy marbles?", "Message", JOptionPane.YES_NO_OPTION);            
                    if (result2 == 0)
                    {
                        do
                        {
                           if ((buy_marble_num > player_money) || buy_marble_num < 0)
                                JOptionPane.showMessageDialog(null, "Invalid! Please try again."); 
                            
                            String buy_marble_text = JOptionPane.showInputDialog(null, "How many marbles you want to buy?");
                            buy_marble_num = Integer.parseInt(buy_marble_text);
                        } while (buy_marble_num > player_money || buy_marble_num < 0);
                        player_money -= buy_marble_num; 
                        player_marble += buy_marble_num;
                        player.displayMessage(player_money, player_marble);
                    }               
                }
            }
            
            do
            {
                if ((gamble_num > player_marble) || gamble_num < 0)
                    JOptionPane.showMessageDialog(null, "Invalid! Please try again."); 
                String gamble_text = JOptionPane.showInputDialog(null, "How many marbles you want to gamble?");
                gamble_num = Integer.parseInt(gamble_text);
            } while((gamble_num > player_marble) || gamble_num < 0);
            player_marble -= gamble_num;
        
            
            int[] bonus = {2, 2, 2, 2, 4, 4, 4, 4, 6, 6, 6, 8, 8, 10};
            Random rand = new Random();
            int randomIndex1 = rand.nextInt(bonus.length);
            int randomNumber1 = bonus[randomIndex1];  
            int player_bonus = randomNumber1;

            JOptionPane.showMessageDialog(null, "Random Bonus: 2x / 4x / 6x / 8x / 10x");            
            JOptionPane.showMessageDialog(null, "Bonus Chance: " + player_bonus + "x!!");                  
            
            int bonus_path1 = 0;
            int bonus_path2 = 0;
            int bonus_path3 = 0;                
            int bonus_path4 = 0;        
            int bonus_path5 = 0;
            
            switch (player_bonus)
            {
                case 2 -> 
                {
                    bonus_path1 = 2;
                    bonus_path2 = 4;                
                    bonus_path3 = 6; 
                    bonus_path4 = 8; 
                    bonus_path5 = 10;
                }
                case 4 -> 
                {
                    bonus_path1 = 3;
                    bonus_path2 = 5;                
                    bonus_path3 = 7; 
                    bonus_path4 = 9;                 
                }
                case 6 -> 
                {
                    bonus_path1 = 2;
                    bonus_path2 = 5;                
                    bonus_path3 = 8;                        
                }    
                case 8 -> 
                {
                    bonus_path1 = 4;
                    bonus_path2 = 6;                    
                }
                case 10 -> 
                {
                    bonus_path1 = 8;                
                }                            
            }
            
            Random random = new Random();
            int playerPath = random.nextInt(10) + 1;
        
            if (playerPath == bonus_path1 || playerPath == bonus_path2 || playerPath == bonus_path3 || playerPath == bonus_path4 || playerPath == bonus_path5)
            {
                JOptionPane.showMessageDialog(null, "SCORE BONUS!"); 
                player_marble += player_bonus * gamble_num;
                player.displayMessage(player_money, player_marble);             
            }    
            else
            {
                JOptionPane.showMessageDialog(null, "Score NO Bonus :(" );
                player.displayMessage(player_money, player_marble);             
            }
        
            if (player_money == 0 && player_marble == 0)
            {
                JOptionPane.showMessageDialog(null, "Game Over. You have no money and marbles left :(" );            
                JOptionPane.showMessageDialog(null, "There is a gift for you: $500 and 50 marbles." );            
                player_money = 500;
                player_marble = 50;
                result3 = JOptionPane.showConfirmDialog(null, "Play Again?", "Message", JOptionPane.YES_NO_OPTION);                 
            }
            else
            {
                result3 = JOptionPane.showConfirmDialog(null, "Play Again?", "Message", JOptionPane.YES_NO_OPTION);     
            }    
            buy_marble_num = 0;
            gamble_num = 0;
        } while (result3 ==0);
    }  
}
