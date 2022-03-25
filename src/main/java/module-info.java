module SlimeGame {
    requires hanyaeger;
	requires javafx.graphics;
    requires com.google.guice;

    exports com.github.hanyaeger.SlimeGame;
    exports com.github.hanyaeger.SlimeGame.entities.rooms;
    exports com.github.hanyaeger.SlimeGame.entities.obstacles;

    opens audio;
    opens backgrounds;
    opens sprites;
}
