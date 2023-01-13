/**
 * Le module {@code fr.univartois.butinfo.qdev2.spaceinvaders} fournit...
 *
 * @author Jules
 *
 * @version 0.1.0
 */
module fr.univartois.butinfo.qdev2.spaceinvaders{
  exports fr.univartois.butinfo.qdev2.spaceinvaders;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.controller;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.model;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.model.movables;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.bonus;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.deplacements;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.murs;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirs;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.tirsaliens;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.model.movables.vaisseaujoueur;
  exports fr.univartois.butinfo.qdev2.spaceinvaders.view;
  
  opens fr.univartois.butinfo.qdev2.spaceinvaders.controller to javafx.fxml;

  requires javafx.fxml;
  requires javafx.graphics;
  requires transitive javafx.controls;
}
