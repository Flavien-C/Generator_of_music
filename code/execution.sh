#! /bin/bash
# -*- coding: utf-8 -*-

echo "Debut d'execution";


# execution d'une classe dans bin
java -cp bin/:lib/jMusic1.6.5.jar/:lib/inst/ model.State;

echo "Fin d'exectution";