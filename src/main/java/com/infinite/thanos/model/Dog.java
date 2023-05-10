package com.infinite.thanos.model;

public class Dog extends AbstractIndividual {
    private String nickname;

    public Dog() {
    }

    public Dog(Long identifier, String nickname) {
        super.setIdentifier(identifier);
        this.nickname = nickname;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "Dog<identifier: " + super.getIdentifier() + ", nickName: " + nickname + ">";
    }
}
