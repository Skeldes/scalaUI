import scalafx.application.JFXApp3
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.Scene
import scalafx.Includes._
import scalafx.scene.control.Alert.AlertType
import scalafx.scene.control._



object alert1 extends JFXApp3{
    override def start() : Unit = {
        stage = new JFXApp3.PrimaryStage{

            //Simple alert
            new Alert(AlertType.Information){
                initOwner(stage)
                headerText = "Je suis une alert de dialogue tmtc"
                contentText = "J'ai un grand message pour toi !"
            }.showAndWait()

            new Alert(AlertType.Warning){
                initOwner(stage)
                title = "CHAT"
                headerText = "Ah"
                contentText = "RAAAH"
            }.showAndWait()

            new Alert(AlertType.Error){
                initOwner(stage)
                title = "Error"
                headerText = "Error 404"
                contentText = "Brain Not Found"
            }.showAndWait()

            //Confirmation dialogue

            val alert = new Alert(AlertType.Confirmation){
                initOwner(stage)
                title = "Confirme Dialogue"
                headerText = "Are you sure ?"
                contentText = "Realy sure ?"
            }

            val resultat = alert.showAndWait()

            resultat match {
                case Some(ButtonType.OK) => println("oh ok")
                case _ => println("Let's go bae")
            }
        }
    }
}