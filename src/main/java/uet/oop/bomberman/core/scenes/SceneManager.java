package uet.oop.bomberman.core.scenes;

import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import uet.oop.bomberman.core.InputHandler;

public class SceneManager {
    public enum SCENES {
        MENU, PLAY
    }

    private static SceneManager instance = null;
    private SCENES currentScene;
    private final MenuScene menu;
    private final PlayScene play;
    private final Scene scene;

    public static SceneManager getInstance() {
        if (instance == null) {
            instance = new SceneManager();
        }
        return instance;
    }

    private SceneManager() {
        menu = new MenuScene();
        play = new PlayScene();

        scene = new Scene(menu.getRoot());

        currentScene = SCENES.MENU;

        InputHandler inputHandler = InputHandler.getInstance();
        inputHandler.handleKeyPressedEvent(scene);
    }

    public SCENES getCurrentScene() {
        return currentScene;
    }

    public void setCurrentScene(SCENES primaryScene) {
        if (primaryScene == SCENES.MENU) {
            currentScene = SCENES.MENU;
            scene.setRoot(menu.getRoot());
        }
        if (primaryScene == SCENES.PLAY) {
            currentScene = SCENES.PLAY;
            scene.setRoot(play.getRoot());
        }
    }

    public Scene getScene() {
        return scene;
    }

    public void update() {
        switch (currentScene) {
            case MENU: {
                scene.setOnMouseClicked(mouseEvent -> {
                    menu.fadeIn();
                });
                scene.setOnKeyPressed(keyEvent -> {
                    if (keyEvent.getCode() == KeyCode.ESCAPE) {
                        menu.fadeOut();
                    }
                });
                break;
            }
            case PLAY: {
                play.update();
                break;
            }
        }
    }

    public void render() {
        switch (currentScene) {
            case MENU: {
                break;
            }
            case PLAY: {
                play.render();
                break;
            }
        }
    }
}
