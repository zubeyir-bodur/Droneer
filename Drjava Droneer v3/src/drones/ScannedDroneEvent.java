package drones;
import java.util.EventObject;

public class ScannedDroneEvent extends EventObject
{
 private static final long serialVersionUID = 3L;

 private boolean isScannedDrone;

 public ScannedDroneEvent( Object source)
 {
  super( source);
  isScannedDrone = false;
 }

 public boolean getScanned()
 {
  return isScannedDrone;
 }

 public synchronized void droneScanned()
 {
  isScannedDrone = true;
 }
}