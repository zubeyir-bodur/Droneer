import java.util.EventObject;

public class HitByProjectileEvent extends EventObject
{
   public HitByProjectileEvent( Object source)
   {
      super( source);
   }
   
   public int getBearing()
   {
      return 0;
      // to do :/
   }
   
}