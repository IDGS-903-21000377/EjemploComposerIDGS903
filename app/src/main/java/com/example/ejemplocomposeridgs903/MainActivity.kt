package com.example.ejemplocomposeridgs903
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PaintingStyle
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//import com.example.ejemplo1composeridgs903.ui.theme.Ejemplo1ComposerIDGS903Theme

data class PersonajeTarjeta(val title: String, val body: String)

private val tarjetas: List<PersonajeTarjeta> = listOf(
    PersonajeTarjeta("Goku", "El protagonista de la serie, conocido por su gran poder y personalidad amigable."),
    PersonajeTarjeta("Vegeta", "Príncipe de los Saiyans, inicialmente un villano, pero luego se une a los Z Fighters."),
    PersonajeTarjeta("Piccolo","Es un namekiano que surgió tras ser creado en los últimos momentos de vida de su padre, siendo su actual reencarnación."),
    PersonajeTarjeta("Bulma","Bulma es la protagonista femenina de la serie manga Dragon Ball y sus adaptaciones al anime Dragon Ball, Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("Freezer","Freezer es el tirano espacial y el principal antagonista de la saga de Freezer."),
    PersonajeTarjeta("Gohan","Son Gohanda en su tiempo en España, o simplemente Gohan en Hispanoamérica, es uno de los personajes principales de los arcos argumentales de Dragon Ball Z, Dragon Ball Super y Dragon Ball GT."),
    PersonajeTarjeta("Krillin","Amigo cercano de Goku y guerrero valiente, es un personaje del manga y anime de Dragon Ball. Es uno de los principales discípulos de Kame-Sen'nin, Guerrero Z, y el mejor amigo de Son Goku."),
    PersonajeTarjeta("Tenshinhan","Maestro de las artes marciales y miembro de los Z Fighters."),
    PersonajeTarjeta("Gotenks","Gotenks también conocido inicialmente como Gotrunk en el doblaje al español de España, es el resultado de la Danza de la Fusión llevada a cabo correctamente por Goten y Trunks."),
    PersonajeTarjeta("Trunks","Hijo de Vegeta y Bulma. Es un mestizo entre humano terrícola y Saiyano nacido en la Tierra, e hijo de Bulma y Vegeta, el cual es introducido en el Arco de los Androides y Cell."),
    PersonajeTarjeta("Master Roshi","Maestro de artes marciales y mentor de Goku. Conocido bajo el nombre de Muten Rosh, fue en su momento el terrícola más fuerte de la Tierra"),
    PersonajeTarjeta("Dende","Sucesor de Piccolo como el nuevo Namekian protector de la Tierra. Es un pequeño namekiano, que vivía en el poblado de Moori, junto a su hermano Scargo y otros tantos de su especie.")
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            EjemploComposerIDGS903Theme {
                Tarjeta(tarjetas)
            }
        }
    }
}

@Composable
fun Tarjeta(personajes: List<PersonajeTarjeta>){
    LazyColumn {
        //ImagenHeroe()
        items(personajes){ personaje ->
            MyPersonajes(personaje)
        }
    }
}

@Composable
fun MyPersonajes(personaje: PersonajeTarjeta){


    Row {
        ImagenHeroe()
        Personajes(personaje)
    }
}

@Composable
fun Personaje(name: String, color: Color, style: TextStyle){
    Text(text = name)
}

@Composable
fun Personajes(personaje: PersonajeTarjeta){
    Column {
        Personaje(personaje.title,
            MaterialTheme.colorScheme.primary,
            MaterialTheme.typography.headlineMedium)

        Personaje(personaje.body,
            MaterialTheme.colorScheme.onBackground,
            MaterialTheme.typography.bodyLarge)
    }
}

@Composable
fun ImagenHeroe(){
    Image(
        painter = painterResource(R.drawable.goku_normal),
        contentDescription = "Goku",
        modifier = Modifier
            .padding(16.dp)
            .size(100.dp)
            .clip(CircleShape)
            .background(MaterialTheme.colorScheme.primary)
    )
}

@Preview
@Composable
fun GreetingPreview() {
    Tarjeta(tarjetas)
}