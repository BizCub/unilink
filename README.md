## 🔗 UniLink

A mod that allows you to use resources from other directories

![preview](https://i.postimg.cc/7hLfZ2TY/0301.gif)

## 💼 Usage

This mod works using symbolic links, which can be used like a folder but don't require reusing (copying) resources. Some launchers also use symbolic links, but the mod works independently of them. It's a configuration file. The first field specifies the path to the directory to use, and the second field specifies the path to the folder where the symbolic link should be placed. The final path can be absolute (e.g., ```C:\...\.minecraft\saves```) or abbreviated (```saves```).

![preview](https://cdn.modrinth.com/data/cached_images/7fde11976eb370b7ad0e335c823529e7eeedc172_0.webp)

If you change the directory used for worlds and then revert the change, the game may freeze while searching for and failing to find the required folder. For this purpose, the configuration file has an option to recreate the folders used by the game.

## 🛠️ How it works
By default, the mod does nothing. However, you can add data to the configuration to create a link: the path from which resources will be used and the path where the symbolic link will be created.

### What follows from this:
* After changing the configuration, new links will be added. Therefore, old, unused links will be deleted.

* Since Minecraft creates some folders, the mod will have to delete the existing folder before creating the link. However, since the mod deletes folders without asking, it has a limitation on deleting directories with files inside. This means that if a folder contains any files, it won't be deleted and the link won't be created.

Creating symbolic links requires certain permissions. Therefore, some launchers that don't have them won't be able to create links. Solution: Run the launcher as administrator.

## 🤝 Support
<a href='https://ko-fi.com/X8X71FI3YO' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://i.postimg.cc/SQ5ZLKg5/support-me-on-kofi-beige.png' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>
