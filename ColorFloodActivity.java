/**
*\brief ce code représente notre projet de developpement android qui consiste a faire un jeu "color Flood" sous android (celui ci est l'activité de notre application)
*\author LECOCQ Guillaume FOUZRI Wael
*\file ColorFloodActivity.java
**/




package p8.demo.colorflood;//**< on déclare que notre programme se situe dans le package*/


/**
*On importe des classes qui se trouvent dans des packages différents.
*/
import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;


/** 
 * la classe activité c'est la fenetre qui s'affiche sur le téléphone suite au declenchemeent de l'application ou l'interface graphique de l'application cette classe herite de la classe activité
 */
public class ColorFloodActivity extends Activity{

    private ColorFloodView view; /** variable view: qui fais reference a la classe ColorFlood.view */
    private SeekBar seekBar; /** variable seekbar:   correspond a la barre de progression

    
    /**
     * Cette méthode est la première qui est lancée au démarrage d'une application.
     * @param savedInstanceState quand l'application est rappelé après avoir tué par le système c'est a cela que sert le parametre de type Bundle
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
        /** on utilise cette methode pour forcer l'application a etre que en portrait et on peut pas tourner le telephone pour avoir le mode paysage
         * @param ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
         */
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        
        super.onCreate(savedInstanceState);/** super.onCreate:  avec super on fait appel à une méthode ou un attribut qui appartient à la superclasse de la méthode actuelle. autrement dit a la classe activity */
        
        /** La méthode void setContentView (View vue) permet d'indiquer l'interface graphique de notre activité.
         */
        setContentView(R.layout.main);

        seekBar = (SeekBar) findViewById(R.id.seekBar); /** seekBar = (SeekBar) findViewById(R.id.seekBar): on crée un objet de type seekbar ou barre de progression pour nos levels */
        seekBar.setMax(4);/** seekBar.setMax(4): on défini le max de la barre a progression qui est égal a 4 c'est a dire de 0 a 4 ce qui correspond a nos 5 levels dans le jeu */
        
        /**
        *la classe seekBar.setOnSeekBarChangeListener c'est comme un rappel(callback) qui informe lorsque le niveau d'activité a été changé. cette classe elle contient 3 sous methode:
        *     onProgressChanged()
        *     onStartTrackingTouch()
        *     onStopTrackingTouch()
        */
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progress = 0;/** int progress = 0: une variable progress qu'on l'initialise a 0 pour dire on commence toujours par le level 0 */
            
            /**
              *la methode onProgressChanged() elle sert quand la barre de progression elle change.
              * @param seekbar c'est la barre dans laquelle on va effectuer le changement.
              * @param progresValue la nouvelle valeur de la variable progress declaré la haut.
              * @param Vrai si le changement d'étape a été lancée par l'utilisateur.
             */
            @Override
            public void onProgressChanged(SeekBar seekBar, int progresValue, boolean fromUser) {
                progress = progresValue;
            }
            
            /**
             *la methode onStartTrackingTouch() elle permet d'avoir une Notification que l'utilisateur a commencé un geste tactile.
             * @param seekbar c'est la barre dans laquelle on va effectuer le changement.
             */
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }
            
            /**
             *la methode onStopTrackingTouch() elle permet d'avoir une Notification que l'utilisateur a terminé un geste tactile.
             * @param seekbar c'est la barre dans laquelle on va effectuer le changement.
             */
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (view.state() < 2 ^ view.getFirstClick()) view.setLevel(progress);/** si l'etat est inferieur a 2 puissance le premier click de l'utilisateur alors on set le level selon la variable progress */
            }
        });

        view=(ColorFloodView) findViewById(R.id.ColorFloodView);/** on crée un objet view du meme type que la classe(ColorFloodView) et ca va etre comme une reference a la vu qu'on a créé */
        
        view.setVisibility(View.VISIBLE);/** setVisibility(): on peut masquer ou afficher des vues */
    }
    
    /** 
     *cete methode est appelé lorsque le système est sur le point de commencer à reprendre une activité précédente.
     */
    public void onPause(){
        super.onPause();/** super.onPause(): avec super on fait appel à une méthode ou un attribut qui appartient à la superclasse de la méthode actuelle, dans ce cas c 'est onPause() */
    }
    /** 
     *cette methode est appelé lorsque l'activité sera commencer à interagir avec l'utilisateur.
     */
    public void onResume(){
        super.onResume();/** super.onResume(): avec super on fait appel à une méthode ou un attribut qui appartient à la superclasse de la méthode actuelle, dans ce cas c 'est onResume() */
    }
    
    /** 
     *cette methode est appelé lorsque l'activité est plus visible pour l'utilisateur, car une autre activité a été repris et couvrant celui-ci.
     */
    public void onStop(){
        super.onStop();/** super.onStop(): avec super on fait appel à une méthode ou un attribut qui appartient à la superclasse de la méthode actuelle, dans ce cas c 'est onStop() */
    }
    
    /** 
     *cette methode est appelé après votre activité a été arrêté, avant d'être repris.
     */
    public void onRestart(){
        view.setRestart(true);/**view.setRestart(true): a chaque fois cette methose est appelé on fait un restart a notre application*/
        super.onRestart();/** super.onRestart(): avec super on fait appel à une méthode ou un attribut qui appartient à la superclasse de la méthode actuelle, dans ce cas c 'est onRestart() */
    }
}
