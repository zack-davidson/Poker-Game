package com.player.impl;

import com.player.ActionState;
import com.player.PlayerAction;

public class FoldAction extends PlayerAction
{

    @Override
    public ActionState getState()
    {
        return ActionState.FOLD;
    }

    @Override
    public void process()
    {
        
    }

}
