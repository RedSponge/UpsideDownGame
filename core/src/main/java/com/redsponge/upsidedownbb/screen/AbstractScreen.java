package com.redsponge.upsidedownbb.screen;

import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.redsponge.upsidedownbb.assets.Assets;
import com.redsponge.upsidedownbb.assets.IAssetRequirer;
import com.redsponge.upsidedownbb.utils.GameAccessor;

public abstract class AbstractScreen extends ScreenAdapter implements IAssetRequirer {

    protected ShapeRenderer shapeRenderer;
    protected SpriteBatch batch;
    protected Assets assets;

    protected GameAccessor ga;
    protected boolean transitioning;

    public AbstractScreen(GameAccessor ga) {
        this.ga = ga;
        this.shapeRenderer = ga.getShapeRenderer();
        this.batch = ga.getSpriteBatch();
        this.assets = ga.getAssets();
    }

    @Override
    public void show() {
        transitioning = false;
    }

    @Override
    public final void render(float delta) {
        throw new RuntimeException("The default render method shouldn'item be called when using an AbstractScreen!");
    }

    /**
     * Called before render, all logic should go here
     * @param delta The delta time from the last frame
     */
    public abstract void tick(float delta);

    /**
     * Called after tick, all rendering should go here
     */
    public abstract void render();

    /**
     * Should the screen be disposed when hidden?
     * @return Should the screen be disposed when hidden? defaults to false
     */
    public boolean shouldDispose() {
        return true;
    }

    public void beginTransition() {
        transitioning = true;
    }
}
