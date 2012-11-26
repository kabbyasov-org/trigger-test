<html>
  <head>
  </head>

  <body bgcolor=white>

    <form action="trigger" method="post">
        <textarea name="payload" ></textarea>
        <input type="submit" name="submit"/>
    </form>

    <form action="http://orl-sra-cmt1:9095/trigger" method="post">
        <input type="hidden" name="code" value="d4297a0273899617978517793b6d28eab9f84f9e"/>
        <input type="hidden" name="repo" value="github.com/serenaSoft/Ant.git"/>
        <input type="hidden" name="branch" value="air"/>
        <input type="submit" name="submit" value="post to AH"/>
    </form>
  </body>
</html> 