#! /bin/bash
# -*- coding: utf-8 -*-

echo "Debut de compilation";


# Suppression de bin si il existe
if [ -d "$bin/" ]; then
    rm -rf bin/;
fi

# Creation du directoire bin
mkdir bin;

# Compilation de src dans bin en utilisant les librairies
javac -cp lib/jMusic1.6.5.jar:lib/inst/ -d bin/ src/*/*.java;

echo "Compilation fini";