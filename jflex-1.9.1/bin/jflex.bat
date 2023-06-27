@echo off

REM Copyright 2020, Gerwin Klein, Régis Décamps, Steve Rowe
REM SPDX-License-Identifier: BSD-3-Clause
REM
REM Please adjust C:\Users\User\Desktop\projeto\Projeto_compilador\jflex-1.9.1\bin and JFLEX_VERSION to suit your needs
REM (please do not add a trailing backslash)

if not defined C:\Users\User\Desktop\projeto\Projeto_compilador\jflex-1.9.1 set C:\Users\User\Desktop\projeto\Projeto_compilador\jflex-1.9.1\bin=C:\JFLEX
if not defined JFLEX_VERSION set JFLEX_VERSION=1.9.1

java -Xmx128m -jar "%C:\Users\User\Desktop\projeto\Projeto_compilador\jflex-1.9.1\bin%\lib\jflex-full-%JFLEX_VERSION%.jar" %*
