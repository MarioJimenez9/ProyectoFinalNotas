package com.example.notesapp

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.navigation.*
import com.example.notesapp.ui.vistas.*
import com.example.notesapp.ui.theme.ProyectoFinalTheme
import com.google.accompanist.navigation.animation.AnimatedComposeNavigator
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    @ExperimentalComposeUiApi
    @ExperimentalAnimationApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val idNota = intent.getLongExtra("idNota", -1)
        setContent {
            ProyectoFinalTheme {
                // A surface container using the 'background' color from the theme
                ComposeNotesApp(idNota)
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.P)
@ExperimentalComposeUiApi
@ExperimentalAnimationApi
@Composable
fun ComposeNotesApp(idNota: Long) {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(navController, startDestination = "lista") {
        mycomposable("lista",
        ) { NotesScreen(navController) }
        mycomposable(
            "noteDetails/{noteID}",
            arguments = listOf(navArgument("noteID") { type = NavType.StringType }),
        )  {
            NoteDetailsScreen(
                navController,
                noteID = it.arguments?.getString("noteID")!!,
            )
        }
        mycomposable(
            "multimedia/{noteID}",
            arguments = listOf(navArgument("noteID") { type = NavType.StringType }),
        ) {
            MultimediaScreen(
                noteID = it.arguments?.getString("noteID")!!,
                navController
            )
        }
        mycomposable(
            "recordatorios/{noteID}",
            arguments = listOf(navArgument("noteID") { type = NavType.StringType }),
        ) {
            ReminderScreen(
                noteID = it.arguments?.getString("noteID")!!,
            )
        }
        mycomposable(
            "detallesFoto/{multimediaID}",
            arguments = listOf(navArgument("multimediaID") { type = NavType.StringType }),
        ) {
            DetailsPictureScreen(
                multimediaID = it.arguments?.getString("multimediaID")!!,
            )
        }
        mycomposable(
            "detallesVideo/{multimediaID}",
            arguments = listOf(navArgument("multimediaID") { type = NavType.StringType }),
        ) {
            DetailsVideoScreen(
                multimediaID = it.arguments?.getString("multimediaID")!!,
            )
        }
        mycomposable(
            "detallesAudio/{multimediaID}",
            arguments = listOf(navArgument("multimediaID") { type = NavType.StringType }),
        ) {
            DetailsAudioScreen(
                multimediaID = it.arguments?.getString("multimediaID")!!,
            )
        }
    }
    if(idNota != -1L)
        navController.navigate(route = "noteDetails/$idNota")
}


@ExperimentalAnimationApi
fun NavGraphBuilder.mycomposable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    content: @Composable AnimatedVisibilityScope.(NavBackStackEntry) -> Unit
) {
    addDestination(
        AnimatedComposeNavigator.Destination(
            provider[AnimatedComposeNavigator::class],
            content,
            enterTransition = { _, _ ->
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )

            },
            exitTransition = { _, _ ->
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Left,
                    animationSpec = tween(700)
                )

            },
            popEnterTransition = { _, _ ->
                slideIntoContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )

            },
            popExitTransition = { _, _ ->
                slideOutOfContainer(
                    AnimatedContentScope.SlideDirection.Right,
                    animationSpec = tween(700)
                )
            }
        ).apply {
            this.route = route
            arguments.forEach { (argumentName, argument) ->
                addArgument(argumentName, argument)
            }
        }
    )
}