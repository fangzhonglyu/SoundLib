package edu.cornell.gdiac.assets;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.ObjectMap;

public class TextureParser implements AssetParser<Texture> {
    private JsonValue root;

    public Class<Texture> getType() {
        return Texture.class;
    }

    public void reset(JsonValue directory) {
        root = directory;
        root = root.getChild( "textures" );
    }

    public boolean hasNext() {
        return root != null;
    }

    public void processNext(AssetManager manager, ObjectMap<String,String> keymap) {
        TextureLoader.TextureParameter params = new TextureLoader.TextureParameter();
        params.genMipMaps = root.getBoolean( "mipmaps",false );
        params.minFilter = ParserUtils.parseFilter(root.get("minFilter"), Texture.TextureFilter.Linear);
        params.magFilter = ParserUtils.parseFilter(root.get("magFilter"), Texture.TextureFilter.Linear);
        params.wrapU = ParserUtils.parseWrap(root.get("wrapU"), Texture.TextureWrap.ClampToEdge);
        params.wrapV = ParserUtils.parseWrap(root.get("wrapV"), Texture.TextureWrap.ClampToEdge);
        params.format = root.getBoolean( "alpha",false ) ? Pixmap.Format.RGBA8888 : Pixmap.Format.RGB888;
        String file = root.getString( "file", null );
        System.out.println("The file is "+file);
        System.out.println(root);
        if (file != null) {
            keymap.put(root.name(),file);
            manager.load( file,Texture.class, params );
        }
        root = root.next();
    }

    public boolean equals(Object o) {
        return o instanceof TextureParser;
    }


}
