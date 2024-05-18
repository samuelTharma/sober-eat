package com.sobereat.uiservice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class MenuItemStatus
{
  private static final Logger logger = LoggerFactory.getLogger(MenuItemStatus.class);
  int orderId;
  String menu;
  String status;

  public MenuItemStatus(int orderId, String menu, String status)
  {
    this.orderId = orderId;
    this.menu = menu;
    this.status = status;
    logger.debug("building menu ... item ... ");
  }
}