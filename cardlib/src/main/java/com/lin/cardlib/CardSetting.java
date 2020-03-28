package com.lin.cardlib;


import com.lin.cardlib.utils.ReItemTouchHelper;

/**
 * Created by linchen on 2018/2/6.
 * mail: linchen@sogou-inc.com
 */

public class CardSetting {

    private int showCount;
    private float cardScale;
    private int cardTranslateDistance;
    private float cardRotateDegree;
    private int swipeDirection;
    private int swipeOutDirection;
    private float swipeThreshold;
    private boolean enableHardware;
    private boolean isLoopCard;
    private int swipeOutAnimDuration;
    private int stackDirection;
    private OnSwipeCardListener swipeListener;

    private CardSetting(Builder builder) {

        showCount = builder.showCount;
        cardScale = builder.cardScale;
        cardTranslateDistance = builder.cardTranslateDistance;
        cardRotateDegree = builder.cardardRotateDegree;
        swipeDirection = builder.swipeDirection;
        swipeOutDirection = builder.swipeOutDirection;
        swipeThreshold = builder.swipeThreshold;
        enableHardware = builder.enableHardware;
        isLoopCard = builder.isLoopCard;
        swipeOutAnimDuration = builder.swipeOutAnimDuration;
        stackDirection = builder.stackDirection;
        swipeListener = builder.swipeListener;
    }

    public int getShowCount() {
        return showCount;
    }

    public float getCardScale() {
        return cardScale;
    }

    public int getCardTranslateDistance() {
        return cardTranslateDistance;
    }

    public float getCardRotateDegree() {
        return cardRotateDegree;
    }

    public int getSwipeDirection() {
        return swipeDirection;
    }

    public int couldSwipeOutDirection() {
        return swipeOutDirection;
    }

    public float getSwipeThreshold() {
        return swipeThreshold;
    }

    public boolean enableHardWare() {
        return enableHardware;
    }

    public boolean isLoopCard() {
        return isLoopCard;
    }

    public int getSwipeOutAnimDuration() {
        return swipeOutAnimDuration;
    }

    public int getStackDirection() {
        return stackDirection;
    }

    public void setSwipeListener(OnSwipeCardListener listener) {
        swipeListener = listener;
    }

    public OnSwipeCardListener getListener() {
        return swipeListener;
    }

    public static class Builder {

        private int showCount;
        private float cardScale;
        private int cardTranslateDistance;
        private float cardardRotateDegree;
        private int swipeDirection;
        private int swipeOutDirection;
        private float swipeThreshold;
        private boolean enableHardware;
        private boolean isLoopCard;
        private int swipeOutAnimDuration;
        private int stackDirection;
        private OnSwipeCardListener swipeListener;

        public Builder() {
            showCount = 3;
            cardScale = 0.1f;
            cardTranslateDistance = 14;
            cardardRotateDegree = 15f;
            swipeDirection = ReItemTouchHelper.LEFT | ReItemTouchHelper.RIGHT
                    | ReItemTouchHelper.UP | ReItemTouchHelper.DOWN;
            swipeOutDirection = ReItemTouchHelper.LEFT | ReItemTouchHelper.RIGHT
                    | ReItemTouchHelper.UP | ReItemTouchHelper.DOWN;
            swipeThreshold = 0.3f;
            enableHardware = true;
            isLoopCard = true;
            swipeOutAnimDuration = 400;
            stackDirection = ReItemTouchHelper.DOWN;
        }

        public Builder setShowCount(int showCount) {
            this.showCount = showCount;
            return this;
        }

        public Builder setCardScale(float cardScale) {
            this.cardScale = cardScale;
            return this;
        }

        public Builder setCardTranslateDistance(int cardTranslateDistance) {
            this.cardTranslateDistance = cardTranslateDistance;
            return this;
        }

        public Builder setCardardRotateDegree(float cardardRotateDegree) {
            this.cardardRotateDegree = cardardRotateDegree;
            return this;
        }

        public Builder setSwipeDirection(int swipeDirection) {
            this.swipeDirection = swipeDirection;
            return this;
        }

        public Builder setSwipeOutDirection(int swipeOutDirection) {
            this.swipeOutDirection = swipeOutDirection;
            return this;
        }

        public Builder setSwipeThreshold(float swipeThreshold) {
            this.swipeThreshold = swipeThreshold;
            return this;
        }

        public Builder setEnableHardWare(boolean enableHardware) {
            this.enableHardware = enableHardware;
            return this;
        }

        public Builder setLoopCard(boolean loopCard) {
            isLoopCard = loopCard;
            return this;
        }

        public Builder setSwipeOutAnimDuration(int swipeOutAnimDuration) {
            this.swipeOutAnimDuration = swipeOutAnimDuration;
            return this;
        }

        public Builder setStackDirection(int stackDirection) {
            this.stackDirection = stackDirection;
            return this;
        }

        public Builder setSwipeListener(OnSwipeCardListener swipeListener) {
            this.swipeListener = swipeListener;
            return this;
        }

        public CardSetting build() {
            return new CardSetting(this);
        }
    }
}
