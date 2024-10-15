import os
import shutil

def organize_directory(path):
    for filename in os.listdir(path):
        if os.path.isfile(os.path.join(path, filename)):
            ext = filename.split('.')[-1]
            ext_folder = os.path.join(path, ext.upper())
            if not os.path.exists(ext_folder):
                os.makedirs(ext_folder)
            shutil.move(os.path.join(path, filename), os.path.join(ext_folder, filename))

if __name__ == "__main__":
    directory = input("Enter the path to the directory: ")
    organize_directory(directory)
