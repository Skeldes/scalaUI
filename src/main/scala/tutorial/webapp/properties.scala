import scalafx.beans.property.DoubleProperty
import scalafx.beans.property.StringProperty
import scalafx.beans.binding.Bindings
import scalafx.application.JFXApp3
import scalafx.scene.paint.Color
import scalafx.scene.shape.Rectangle
import scalafx.scene.Scene
import scalafx.Includes._



object Property extends App {
    val speed = DoubleProperty(55)
    speed.onChange{ (source, oldValue, newValue) => {
        println("source :"+source+" ancienne valeur :"+oldValue+" Nouvelle valeur : "+newValue)
    }}

    speed.value = 68
}

object Property2 extends App{
    val prop = DoubleProperty(0)

    val subscription = prop.onChange { (_,_, newValue) => println(s"Property changed value $newValue")}

    prop.value = 1

    subscription.cancel()

    prop.value = 18
}


object Property3 extends App {


    val a = DoubleProperty(5)
    a.onChange { (here,_,newVal) => println(s"New val of a is $newVal")}
    val b = DoubleProperty(10)
    b.onChange { (here,_,newVal) => println(s"New val of b is $newVal")}

    a <==> b //effet immediat 


    b.value = 20

    a.value = 10
}


object Property4 extends App {
    val hauteur = DoubleProperty(10)
    val base = DoubleProperty(5)
    val air = DoubleProperty(0)

    air.onChange( (_,_,newVal)=>{println(s"la nouvelle aire est : $newVal")})

    air <== (base * hauteur) / 2

    base.value = 12
}

object Property5 extends JFXApp3 {
    override def start() : Unit = {
        stage = new JFXApp3.PrimaryStage {
            title.value = "Rectangle switch color"
            width = 400
            height = 300
            scene = new Scene {
                fill = Color.LightGreen
                content = new Rectangle {
                    x = 25
                    y = 40
                    width = 100
                    height = 100
                    fill <== when (hover) choose Color.Green otherwise Color.Red
                }
            }
        }
    }
}


object Property56 extends App {


    val a = new StringProperty()

    val b = Bindings.createStringBinding(
        () => Option(a.value).getOrElse("").toLowerCase,
        a
    )

    a .value = "Hello"

    println(s"Setting 'a' to ${a.value}, 'b' = ${b.value}")

}