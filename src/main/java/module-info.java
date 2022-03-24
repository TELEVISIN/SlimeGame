module SlimeGame {
    requires hanyaeger;
	requires javafx.graphics;

    exports com.github.hanyaeger.SlimeGame;

    opens audio;
    opens backgrounds;
    opens sprites;
}
