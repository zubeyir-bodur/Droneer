import java.util.EventListener;

public interface HitListener extends EventListener
{
   public void onHitByProjectile( HitByProjectileEvent e);
}