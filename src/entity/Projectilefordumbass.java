package entity;

import main.GamePanel;

public class Projectilefordumbass extends Entity{

    Entity user;

    public Projectilefordumbass(GamePanel gp) {
        super(gp);

    }

    public void set(int worldX, int worldY, String direction, boolean alive, Entity user)
    {
        this.worldX = worldX;
        this.worldY = worldY;
        this.direction = direction;
        this.alive = alive;
        this.user = user;
        this.life = this.maxLife;  //Reset the life to the max value every time you shoot it.
    }
    public void update()
    {

        if(user == gp.player)
        {
            int monsterIndex = gp.cChecker.checkEntity(this,gp.monster);
            if(monsterIndex != 999) 
            {
                
                alive = false;
            }
        }
        if(user != gp.player)
        {
            boolean contactPlayer = gp.cChecker.checkPlayer(this);
            if(gp.player.invincible == false && contactPlayer == true)
            {

                alive = false;
            }
        }

        switch (direction)
        {
            case "up": worldY -= speed; break;
            case "down": worldY += speed; break;
            case "left": worldX -= speed; break;
            case "right": worldX += speed; break;
        }

        life--;
        if(life <= 0)
        {
            alive = false;  //once you shoot projectile, it lose its life
        }

        spriteCounter++;
        if(spriteCounter > 12)
        {
            if(spriteNum == 1)
            {
                spriteNum = 2;
            }
            else if(spriteNum == 2)
            {
                spriteNum = 1;
            }
            spriteCounter = 0;
        }

    }
    public boolean haveResource(Entity user)
    {
        boolean haveResource = false;
        return haveResource;
    }
    public void subtractResource(Entity user)
    {

    }
}