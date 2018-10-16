package wth.hsd.de.wth_example_mod_apk;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.FileNotFoundException;
import java.io.IOException;

public class WTHModProvider extends ContentProvider {
    private static final String LOGTAG = "wth.modprovider";

    @Override
    public AssetFileDescriptor openAssetFile(Uri uri, String mode ) throws FileNotFoundException
    {
        Log.v(LOGTAG, "AssetsGetter: Open asset file");

        AssetManager am = getContext( ).getAssets( );

        String file_name = uri.getPath().substring(1, uri.getPath().length());

        if( file_name != "Mods")
            throw new FileNotFoundException("Only accessing the 'Mods' folder is allowed.");

        AssetFileDescriptor afd = null;

        try
        {
            afd = am.openFd( file_name );
        }
        catch(IOException e)
        {
            e.printStackTrace( );
        }

        return afd;
    }

    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
